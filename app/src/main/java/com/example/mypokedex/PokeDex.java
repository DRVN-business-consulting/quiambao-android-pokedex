/*
package com.example.mypokedex;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypokedex.adapter.MyAdapter;
import com.example.mypokedex.model.Pokemon;

import java.util.List;

public class PokeDex extends AppCompatActivity {
    RecyclerView myRecyclerView;
    MyAdapter myAdapter;
    List<Pokemon> pokemonList = List.of(
            new Pokemon("Bulbasaur",R.drawable.bullbasaur,"Seed Pokémon","Bulbasaur can be seen napping in bright sunlight. There is a seed on its back. By soaking up the sun’s rays, the seed grows progressively larger."),
            new Pokemon("Charizard", R.drawable.charizard,"Flame Pokémon","Charizard flies around the sky in search of powerful opponents. It breathes fire of such great heat that it melts anything. However, it never turns its fiery breath on any opponent weaker than itself."),
            new Pokemon("Charmander", R.drawable.charmander,"Lizard Pokémon","The flame that burns at the tip of its tail is an indication of its emotions. The flame wavers when Charmander is enjoying itself. If the Pokémon becomes enraged, the flame burns fiercely."),
            new Pokemon("Meowth", R.drawable.meowth,"Scratch Cat Pokémon","It loves coins, so if you give it one, you can make friends with Meowth easily. But it’s fickle, so you can’t count on that friendship lasting."),
            new Pokemon("Snorlax", R.drawable.snorlax,"Sleeping Pokémon","It has no interest in anything other than eating. Even if you climb up on its stomach while it’s napping, it doesn’t seem to mind at all!"),
            new Pokemon("JigglyPuff", R.drawable.jigglypuff,"Balloon Pokémon","The songs they sing are totally different depending on the region they live in. Some even sound like they’re shouting!")
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_pokedex);

        myRecyclerView = findViewById(R.id.MyPokeDex);

        // Set up the adapter with click listener
        myAdapter = new MyAdapter(pokemonList, pokemon -> {
            Intent intent = new Intent(PokeDex.this, PokemonDetails.class);

            // Pass additional details about the selected Pokémon
            intent.putExtra("pokemon_name", pokemon.getName());
            intent.putExtra("pokemon_image", pokemon.getImageResId()); // Can be a resource ID or a URL
            intent.putExtra("pokemon_species", pokemon.getSpecies());
            intent.putExtra("pokemon_description", pokemon.getDescription());


            // Start the detail activity
            startActivity(intent);
        });

        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerView.setAdapter(myAdapter);
    }

}
*/
