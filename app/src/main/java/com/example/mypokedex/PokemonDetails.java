package com.example.mypokedex;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PokemonDetails extends AppCompatActivity {

    private ImageView ivPokemonImage;
    private TextView tvPokemonName, tvPokemonSpecies, tvPokemonDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemon_detail);

        // Get references to UI elements
        ivPokemonImage = findViewById(R.id.ivPokemonImage);
        tvPokemonName = findViewById(R.id.tvPokemonName);
        tvPokemonSpecies = findViewById(R.id.tvPokemonSpecies);
        tvPokemonDescription = findViewById(R.id.tvPokemonDescription);



        // Get the data passed from PokeDex Activity
        String pokemonName = getIntent().getStringExtra("pokemon_name");
        int pokemonImage = getIntent().getIntExtra("pokemon_image", 0); // Default to 0 if no image
        String pokemonSpecies = getIntent().getStringExtra("pokemon_species");
        String pokemonDescription = getIntent().getStringExtra("pokemon_description");


        // Set data to UI elements
        ivPokemonImage.setImageResource(pokemonImage);
        tvPokemonName.setText(pokemonName);
        tvPokemonSpecies.setText(pokemonSpecies);
        tvPokemonDescription.setText(pokemonDescription);

        ivPokemonImage.setOnClickListener(view -> {

            finish();
        });

    }

}
