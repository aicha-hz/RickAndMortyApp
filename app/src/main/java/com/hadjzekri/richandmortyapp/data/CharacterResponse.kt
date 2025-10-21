package com.hadjzekri.richandmortyapp.data

data class CharacterResponse(
    val info : Info,
    val results: ArrayList<Character>
)

data class Info(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev:String?
)
