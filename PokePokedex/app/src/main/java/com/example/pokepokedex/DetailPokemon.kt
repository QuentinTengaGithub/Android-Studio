package com.example.pokepokedex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.pokemon_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pokemon_detail)

        val originIntent = intent
        val details : PokemonDetailModel = originIntent.getSerializableExtra("details") as PokemonDetailModel

        Glide.with(this).load(details.picture).into(pokemon_detail_picture)


        pokemon_detail_name.text = details.name
        pokemon_detail_speed.text = details.speed.toString()
        pokemon_detail_hp.text = details.hp.toString()
        pokemon_detail_attack.text = details.attack.toString()
        pokemon_detail_defense.text = details.defense.toString()
        pokemon_detail_special_attack.text = details.special_attack.toString()
        pokemon_detail_special_defense.text = details.special_defense.toString()
    }
}