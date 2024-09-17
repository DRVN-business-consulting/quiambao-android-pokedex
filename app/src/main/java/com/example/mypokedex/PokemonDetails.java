package com.example.mypokedex;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.mypokedex.fragments.FavoritesFragment;
import com.example.mypokedex.fragments.PokemonFragment;
import com.example.mypokedex.fragments.TrainerFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PokemonDetails extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemon_detail);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);


        loadFragment(new PokemonFragment());  // Make sure this fragment shows the details properly

        // Handle bottom navigation item clicks
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
                if (item.getItemId() == R.id.nav_pokemons){
                    selectedFragment = new PokemonFragment();
                } else if (item.getItemId() == R.id.nav_favorites){
                    selectedFragment = new FavoritesFragment();
                } else if (item.getItemId() == R.id.nav_trainer){
                    selectedFragment = new TrainerFragment();
                };



            if (selectedFragment != null) {
                loadFragment(selectedFragment);
            }
            return true;
        });
    }

    // Method to load the selected fragment into the fragment container
    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);  // Make sure you have a fragment container in your layout
        transaction.commit();
    }
}
