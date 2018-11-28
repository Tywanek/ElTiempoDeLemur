package com.radlab.eltiempodelemur.network;

import com.radlab.eltiempodelemur.network.response.GeoResponse;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface ElTiempoAPI {

    @GET("/searchJSON")
    Call<GeoResponse> getWeather(@Query("q") String name,
                                 @Query("maxRows") int maxRows,
                                 @Query("startRow") int startRow,
                                 @Query("lang") String lang,
                                 @Query("isNameRequired") Boolean isNameRequired,
                                 @Query("style") String style,
                                 @Query("username") String username);


}
