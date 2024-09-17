package com.example.mypokedex.model;

public class Pokemon {
    private String name;
    private String imageResId; // You can change this based on your API response

    public Pokemon(String name, String imageUrl) {
        this.name = name;
        this.imageResId = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageResId;
    }
}
