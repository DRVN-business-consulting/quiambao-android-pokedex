package com.example.mypokedex.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mypokedex.R;
import com.example.mypokedex.adapters.MyAdapter;
import com.example.mypokedex.api.API;
import com.example.mypokedex.model.Pokemon;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonFragment extends Fragment {
    private RecyclerView recyclerView;
    private MyAdapter pokemonAdapter;
    private List<Pokemon> pokemonList;

    // Create a new instance of the fragment and pass the RecyclerView ID as an argument
    public static PokemonFragment newInstance(RecyclerView recyclerView) {
        PokemonFragment fragment = new PokemonFragment();
        Bundle args = new Bundle();
        args.putInt("recycler_view_id", recyclerView.getId());
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.main_pokedex, container, false);

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView);
        if (recyclerView == null) {
            throw new NullPointerException("RecyclerView is null");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        pokemonList = new ArrayList<>();
/*
        pokemonAdapter = new MyAdapter(pokemonList);
*/
        recyclerView.setAdapter(pokemonAdapter);

        // Fetch Pokémon list from API
        fetchPokemonList();

        return view;
    }

    private void fetchPokemonList() {
        API.userApi().getPokemons().enqueue(new Callback<List<Pokemon>>() {
            @Override
            public void onResponse(Call<List<Pokemon>> call, Response<List<Pokemon>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    pokemonList.addAll(response.body());
                    pokemonAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Pokemon>> call, Throwable t) {
                // Handle failure
            }
        });
    }
}
