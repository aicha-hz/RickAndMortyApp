package com.hadjzekri.richandmortyapp



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hadjzekri.richandmortyapp.R
import com.hadjzekri.richandmortyapp.Character
import com.squareup.picasso.Picasso

class CharacterAdapter(private val characterList: List<Character>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageViewCharacter)
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewSpecies: TextView = itemView.findViewById(R.id.textViewSpecies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_item, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characterList[position]
        holder.textViewName.text = character.name
        holder.textViewSpecies.text = character.species
        Picasso.get().load(character.image).into(holder.imageView)
    }

    override fun getItemCount(): Int = characterList.size
}
