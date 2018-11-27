
package com.radlab.eltiempodelemur.network.models.weatherModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherObservation {

    @SerializedName("lng")
    @Expose
    private Double lng;
    @SerializedName("observation")
    @Expose
    private String observation;
    @SerializedName("ICAO")
    @Expose
    private String iCAO;
    @SerializedName("clouds")
    @Expose
    private String clouds;
    @SerializedName("dewPoint")
    @Expose
    private String dewPoint;
    @SerializedName("datetime")
    @Expose
    private String datetime;
    @SerializedName("temperature")
    @Expose
    private String temperature;
    @SerializedName("humidity")
    @Expose
    private Integer humidity;
    @SerializedName("stationName")
    @Expose
    private String stationName;
    @SerializedName("weatherCondition")
    @Expose
    private String weatherCondition;
    @SerializedName("windDirection")
    @Expose
    private Integer windDirection;
    @SerializedName("windSpeed")
    @Expose
    private String windSpeed;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("cloudsCode")
    @Expose
    private String cloudsCode;

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getICAO() {
        return iCAO;
    }

    public void setICAO(String iCAO) {
        this.iCAO = iCAO;
    }

    public String getClouds() {
        return clouds;
    }

    public void setClouds(String clouds) {
        this.clouds = clouds;
    }

    public String getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(String dewPoint) {
        this.dewPoint = dewPoint;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public Integer getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(Integer windDirection) {
        this.windDirection = windDirection;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public String getCloudsCode() {
        return cloudsCode;
    }

    public void setCloudsCode(String cloudsCode) {
        this.cloudsCode = cloudsCode;
    }

}
