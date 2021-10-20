package com.example.pokepokedex

import java.io.Serializable

class PokemonDetailModel(
    val id: Int,
    val picture: String,
    val name: String,
    val height: Int,
    val weight: Int,
    val speed: Int,
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val special_attack: Int,
    val special_defense: Int,
    val types: String
) : Serializable