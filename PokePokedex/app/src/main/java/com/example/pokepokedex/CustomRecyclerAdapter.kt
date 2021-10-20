package com.example.pokepokedex

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CustomRecyclerAdapter(
    private val context: Context,
    private val data: List<PokemonModel>,
    private val onItemClickListener: View.OnClickListener) :
    RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //Afficher le nom du pokemon
        val nameTextView: TextView = itemView.findViewById(R.id.pokemon_list_name)
        //Afficher l'image du pokemon
        val imageView: ImageView = itemView.findViewById(R.id.pokemon_list_type)
    }
    override fun getItemCount(): Int {
        return data.size
    }

    // called when a new viewholder is required to display a row
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.pokemon_list, parent, false)
        itemView.setOnClickListener(onItemClickListener)

        return ViewHolder(itemView)
    }
    // called when a row is about to be displayed
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
// retrieve the item at the specified position
        val currentItem = data[position]
// put the data
        holder.nameTextView.text = currentItem.name
        //Glide.with(context).load(currentItem.picture.into(holder.imageView)
        holder.itemView.tag = position
    }
}