package com.hadjzekri.richandmortyapp.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApi {
    @GET("character")
    suspend fun getCharacters(
        @Query("page") page: Int =1,
        @Query("name") name: String? = null

    ): Response<CharacterResponse>
}