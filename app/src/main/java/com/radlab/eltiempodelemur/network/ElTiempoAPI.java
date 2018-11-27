package com.radlab.eltiempodelemur.network;

import com.radlab.eltiempodelemur.network.response.GeoResponse;
import retrofit.Call;
import retrofit.http.GET;

public interface ElTiempoAPI {

    @GET("/searchJSON?q=Madrid&maxRows=20&startRow=0&lang=en&isNameRequired=true&style=FULL&username=ilgeonamessample")
    Call<GeoResponse> getWeather();


}
