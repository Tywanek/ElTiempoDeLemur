
package com.radlab.eltiempodelemur.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.radlab.eltiempodelemur.network.models.weatherModels.WeatherObservation;

import java.util.List;

public class WeatherResponse {

    @SerializedName("weatherObservations")
    @Expose
    private List<WeatherObservation> weatherObservations = null;

    public List<WeatherObservation> getWeatherObservations() {
        return weatherObservations;
    }

    public void setWeatherObservations(List<WeatherObservation> weatherObservations) {
        this.weatherObservations = weatherObservations;
    }

}
