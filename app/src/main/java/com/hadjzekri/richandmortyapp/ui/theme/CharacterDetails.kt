package com.hadjzekri.richandmortyapp.ui.theme

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hadjzekri.richandmortyapp.data.Character
import com.hadjzekri.richandmortyapp.databinding.ActivityCharacterDetailsBinding
import com.squareup.picasso.Picasso

class CharacterDetails : AppCompatActivity() {
    lateinit var binding: ActivityCharacterDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCharacterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val character=intent.getSerializableExtra("character") as Character
        binding.name.text=character.name.toString()
        binding.species.text=character.species.toString()
        binding.status.text=character.status.toString()
        Picasso.get().load(character.image.toString()).into(binding.image)

    }
}