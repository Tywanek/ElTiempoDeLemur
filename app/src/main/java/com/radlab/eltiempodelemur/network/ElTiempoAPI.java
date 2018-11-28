package com.radlab.eltiempodelemur.network;

import com.radlab.eltiempodelemur.network.response.GeoResponse;
import com.radlab.eltiempodelemur.network.response.WeatherResponse;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface ElTiempoAPI {

    @GET("/searchJSON")
    Call<GeoResponse> getGeoResponse(@Query("q") String name,
                                     @Query("maxRows") int maxRows,
                                     @Query("startRow") int startRow,
                                     @Query("lang") String lang,
                                     @Query("isNameRequired") Boolean isNameRequired,
                                     @Query("style") String style,
                                     @Query("username") String username);

    @GET("/weatherJSON")
    Call<WeatherResponse> getWeatherResponse(@Query("north") Double north,
                                             @Query("south") Double south,
                                             @Query("east") Double east,
                                             @Query("west") Double west,
                                             @Query("username") String username);
}
