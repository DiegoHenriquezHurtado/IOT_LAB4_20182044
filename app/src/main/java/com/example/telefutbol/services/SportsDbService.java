package com.example.telefutbol.services;

import com.example.telefutbol.Entity.Countries;
import com.example.telefutbol.Entity.Leagues;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SportsDbService {

    @GET("/api/v1/json/3/all_leagues.php")
    Call<Leagues> getLigas();

    @GET("/api/v1/json/3/search_all_leagues.php")
    Call<Countries> getLeaguesPorPais(@Query("c") String country);
}
