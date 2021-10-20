package com.example.pokepokedex

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonWS {
    //Display the pokemon list
    @GET("https://pokeapi.co/api/v2/item/{id or name}/")
    fun getGameList(): Call<List<PokemonModel>>
}