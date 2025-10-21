package com.hadjzekri.richandmortyapp.ui.theme.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hadjzekri.richandmortyapp.api.RetrofitInstance
import com.hadjzekri.richandmortyapp.data.Character
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterViewModel: ViewModel(){
    val characters= MutableLiveData<ArrayList<Character>>()
    private var currentQuery: String? = null
    var currentpage=1
    var isLoading=false
    var isLastPage=false

    fun getCharacters (query: String? = null){
        if (isLoading || isLastPage) return
        isLoading = true
        if (query != currentQuery){
            currentQuery=query
            currentpage=1
            characters.postValue(arrayListOf())
        }

        CoroutineScope(Dispatchers.IO).launch {

        try {
            val response= RetrofitInstance.characterApi.getCharacters(
                page= currentpage,
                name =  currentQuery
            )

            if ( response.isSuccessful){
                val data =response.body()
                Log.i("CharacterViewModel","success Api call")
                CoroutineScope(Dispatchers.Main).launch {
                    val currentList= characters.value ?: arrayListOf()
                    currentList.addAll(data?.results ?: emptyList())
                    characters.value= currentList
                    isLastPage= data?.info?.next==null
                    currentpage++
                    isLoading=false



                }

            }else{
                val errorMessage=response.toString()
                Log.i("CharacterViewModel",errorMessage)
                isLoading=false
            }
        }catch (e:Exception){
            Log.e("CharacterViewModel",e.message.toString())
            isLoading=false
        }
    }}


}