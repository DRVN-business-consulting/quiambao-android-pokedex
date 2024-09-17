package com.example.mypokedex.model;

import java.util.List;

public class Pokemon {
    private String name;
    private int imageResId; // This can be your local image resource ID or a URL
    private String species;
    private String description;



    public Pokemon(String name, int imageResId, String species, String description
                  ) {
        this.name = name;
        this.imageResId = imageResId;
        this.species = species;
        this.description = description;

    }

    public String getName() { return name; }
    public int getImageResId() { return imageResId; }
    public String getSpecies() { return species; }
    public String getDescription() { return description; }

}
