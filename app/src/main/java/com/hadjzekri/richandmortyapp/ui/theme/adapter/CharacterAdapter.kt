package com.hadjzekri.richandmortyapp.ui.theme.adapter



import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hadjzekri.richandmortyapp.ui.theme.CharacterDetails
import com.hadjzekri.richandmortyapp.R
import com.hadjzekri.richandmortyapp.data.Character
import com.squareup.picasso.Picasso

class CharacterAdapter(val context: Context, private var characters: ArrayList<Character>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageViewCharacter)
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewSpecies: TextView = itemView.findViewById(R.id.textViewSpecies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.character_item, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.textViewName.text = character.name
        holder.textViewSpecies.text = character.species
        Picasso.get().load(character.image).into(holder.imageView)
        holder.itemView.setOnClickListener{
        var i =Intent(context, CharacterDetails::class.java)
            i.putExtra("character",character)
            context.startActivity(i)
        }
    }

    override fun getItemCount(): Int = characters.size

    fun updateData(newCharacters: ArrayList<Character>) {
        characters = newCharacters
        notifyDataSetChanged()
    }
}
