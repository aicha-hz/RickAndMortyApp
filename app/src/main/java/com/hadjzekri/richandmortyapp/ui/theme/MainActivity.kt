package com.hadjzekri.richandmortyapp.ui.theme

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hadjzekri.richandmortyapp.databinding.ActivityMainBinding
import com.hadjzekri.richandmortyapp.ui.theme.adapter.CharacterAdapter
import com.hadjzekri.richandmortyapp.ui.theme.viewModel.CharacterViewModel


class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: CharacterViewModel
    private lateinit var adapter: CharacterAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // declaring my variables
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)
        adapter = CharacterAdapter(this, arrayListOf())

        // conecting the recycleview with the adapter
        binding.recycleViewCharacter.layoutManager = GridLayoutManager(this, 2)
        binding.recycleViewCharacter.adapter = adapter

        // loading data from api
        viewModel.characters.observe(this){list ->
            list?.let { adapter.updateData(it) }
        }
        viewModel.getCharacters()

        // handle the searching case
        binding.editTextSearch.addTextChangedListener { text->
            val query= text.toString().trim()
            if (query.length >= 2 || query.isEmpty()){
                viewModel.getCharacters(query)
            }else{
                viewModel.getCharacters()
            }
        }
        // handle pagination
        binding.recycleViewCharacter.addOnScrollListener(object: RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
                if ( (visibleItemCount + firstVisibleItemPosition) >= totalItemCount - 5){
                    viewModel.getCharacters()
                }
            }
        })



    }
}