package com.hadjzekri.richandmortyapp.api

import com.hadjzekri.richandmortyapp.data.CharacterApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object{
        private val retrofit by lazy {
            Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
            .build()
        }
        val characterApi by lazy {
            retrofit.create(CharacterApi::class.java)
}
    }
}