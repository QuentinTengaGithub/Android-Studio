package com.example.pokepokedex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {

    private val service: PokemonWS = getWSService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //main_list : id of RecyclerView in activity_main.xml
        main_list.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        main_list.setHasFixedSize(true)
        main_list.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false)

        loadPokemonList()
    }

    private fun getWSService(): PokemonWS {
        val baseURL = "https://pokeapi.co/docs/v2/"
        //val baseURL2 = "http://www.surleweb.xyz/api/pokemons.json"
        val jsonConverter = GsonConverterFactory.create(GsonBuilder().create())
        // Create a Retrofit client object targeting the provided URL
        // and add a JSON converter (because we are expecting json responses)
        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(jsonConverter)
            .build()
        // Use the client to create a service:
        // an object implementing the interface to the WebService
        return retrofit.create(PokemonWS::class.java)
    }

    private fun loadPokemonList() {
        val wsCallback: Callback<List<PokemonModel>> = object : Callback<List<PokemonModel>> {
            override fun onFailure(call: Call<List<PokemonModel>>, t: Throwable) {
                // Code here what happens if calling the WebService fails
                Log.w("TAG", "WebService call failed")
            }
            override fun onResponse(call: Call<List<PokemonModel>>, response:
            Response<List<PokemonModel>>
            ) {
                if (response.code() == 200) {
                    // We got our data !
                    //main_loading_text.visibility = View.GONE
                    val responseData = response.body()

                    val myItemClickListener = View.OnClickListener {
                        // we retrieve the row position from its tag
                        val position = it.tag as Int
                        val clickedItem = responseData?.get(position)
                        // do stuff
                        Toast.makeText(
                            this@MainActivity,
                            "Clicked " + clickedItem?.name,
                            Toast.LENGTH_SHORT)
                            .show()

                        //displayDetails(clickedItem?.id!!)
                    }

                    main_list.adapter = CustomRecyclerAdapter(this@MainActivity, responseData!!, myItemClickListener)
                }
            }
        }

        service.getGameList().enqueue(wsCallback)
    }

    /*private fun displayDetails(gameId: Int) {
        val wsCallback: Callback<PokemonDetailModel> = object : Callback<PokemonDetailModel> {
            override fun onFailure(call: Call<PokemonDetailModel>, t: Throwable) {

                Log.w("TAG", "WebService call failed")
            }
            override fun onResponse(call: Call<PokemonDetailModel>, response:
            Response<PokemonDetailModel>
            ) {
                if (response.code() == 200 && response.body() != null) {

                    val details : PokemonDetailModel = response.body()!!
                    val navIntent = Intent(this@MainActivity, DetailActivity::class.java)
                    navIntent.putExtra("details", details)
                    startActivity(navIntent)
                }
            }
        }

        service.getGameDetails(gameId).enqueue(wsCallback)
    }*/

}