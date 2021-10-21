package com.example.exament3.service;

import com.example.exament3.personaje.Personaje;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {
    @GET("/lista")
    Call<List<Personaje>> all();
}
