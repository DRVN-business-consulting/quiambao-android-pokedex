package com.example.mypokedex.api;

import com.example.mypokedex.dto.request.LoginDto;
import com.example.mypokedex.dto.request.SignUpDto;
import com.example.mypokedex.dto.response.LoginResponse;
import com.example.mypokedex.dto.response.RefreshTokenDto;
import com.example.mypokedex.dto.response.UserDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

public interface UserApi {

    @POST("login")
    Call<RefreshTokenDto> login(@Body LoginDto user);


    @POST("signup")
    Call<UserDto> signup(@Body SignUpDto signupDto);

    @POST("refresh-token")
    Call<RefreshTokenDto> refreshToken();

    @GET("user/me")
    Call<UserDto> me();

    @PATCH("user/me")
    Call<UserDto> updateMe();
    @GET("user/Pokemon")
    Call<List<com.example.mypokedex.model.Pokemon>> getPokemons();

}
