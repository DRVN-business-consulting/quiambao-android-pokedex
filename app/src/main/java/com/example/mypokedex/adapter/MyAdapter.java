package com.example.mypokedex.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypokedex.R;
import com.example.mypokedex.model.Pokemon;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Pokemon> pokemonList;
    private OnItemClickListener listener; // Add a listener for item clicks

    // Constructor with listener
    public MyAdapter(List<Pokemon> pokemonList, OnItemClickListener listener) {
        this.pokemonList = pokemonList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.pokedex, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Pokemon pokemon = pokemonList.get(holder.getAdapterPosition());
        holder.bind(pokemon, listener);
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView ivPokemon;
        TextView tvPokemon;

        public MyViewHolder(View itemView) {
            super(itemView);
            ivPokemon = itemView.findViewById(R.id.ivPokemon);
            tvPokemon = itemView.findViewById(R.id.tvPokemon);
        }

        public void bind(final Pokemon pokemon, final OnItemClickListener listener) {
            ivPokemon.setImageResource(pokemon.getImageResId());
            tvPokemon.setText(pokemon.getName());


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(pokemon); // Pass the clicked Pokemon to the listener
                }
            });
        }
    }


    public interface OnItemClickListener {
        void onItemClick(Pokemon pokemon); // Define a method for click handling
    }
}
