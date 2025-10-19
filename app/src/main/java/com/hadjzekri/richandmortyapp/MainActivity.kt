package com.hadjzekri.richandmortyapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.hadjzekri.richandmortyapp.databinding.ActivityMainBinding


class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerView= binding.recycleViewCharacter

        recyclerView.layoutManager=GridLayoutManager(this, 2)
        // this is a temporary sample of data
        val sampleCharacters = listOf(
            Character("Rick Sanchez", "Human", "https://static.wikia.nocookie.net/rickandmorty/images/a/a6/Rick_Sanchez.png/revision/latest/scale-to-width-down/536?cb=20250817060829"),
            Character("Morty Smith", "Human", "https://static.wikia.nocookie.net/rickandmorty/images/3/3a/Morty_Smith.png/revision/latest/scale-to-width-down/536?cb=20250817060610"),
            Character("Summer Smith", "Human", "https://static.wikia.nocookie.net/rickandmorty/images/f/f7/Summer_Smith.png/revision/latest/scale-to-width-down/536?cb=20250817061112"),
            Character("Beth Smith", "Human", "https://static.wikia.nocookie.net/rickandmorty/images/1/1b/Beth_Smith.png/revision/latest/scale-to-width-down/536?cb=20250817061239"),
            Character("Mr. Poopybutthole", "Unknown", "https://static.wikia.nocookie.net/rickandmorty/images/8/8f/Mr_Poopybutthole.png/revision/latest/scale-to-width-down/536?cb=20250817062029")
        )
        recyclerView.adapter = CharacterAdapter(sampleCharacters)

    }
}