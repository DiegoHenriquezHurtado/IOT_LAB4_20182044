package com.example.telefutbol.services;

import com.example.telefutbol.Entity.Countries;
import com.example.telefutbol.Entity.Leagues;
import com.example.telefutbol.Entity.Posiciones;
import com.example.telefutbol.Entity.Resultados;
import com.example.telefutbol.Entity.Table;

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

    @GET("/api/v1/json/3/lookuptable.php")
    Call<Posiciones> getPosiciones(@Query("l") String idLiga , @Query("s") String temporada);

    @GET("/api/v1/json/3/eventsround.php")
    Call<Resultados> getResultados(@Query("id") String idLiga, @Query("r") String ronda, @Query("s") String temporada);
}
