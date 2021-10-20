package com.example.hellogames

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    val data : MutableList<GameList> = arrayListOf()
    data.add(GameList("Han", "SlidingPuzzle"))
    data.add(GameList("Darth", "Sudoju"))
    data.add(GameList("Darth", "Tic Tac Toe"))
    data.add(GameList("Darth", "Game of Life"))

    activity_main_game.setHasFixedSizeTrue(true)
    activity_main_game.LayoutManager = LinearLayoutManager(this)

    Glide
        .with(this)
        .load("https://androidlessonsapi.herokuapp.com/api/help/")
        .into(activity_main_game_view)
}