package com.example.mypokedex.dto.request;

public class SignUpDto {
    private String username;
    private String password;
    private String name;
    private String address;
    private int age; // Use Integer if you want to allow nulls

    // Constructor, getters, and setters
    public SignUpDto(String username, String password, String name, String address, int age) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.age = age;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
