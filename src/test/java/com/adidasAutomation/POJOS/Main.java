
package com.adidasAutomation.POJOS;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonProperty;

public class Main {

    @SerializedName("temp")
    @Expose
    private Double temp;
    @JsonProperty("feels_like")
    @Expose
    private Double feels_like;
    @JsonProperty("temp_min")
    @Expose
    private Double tempMin;
    @JsonProperty("temp_max")
    @Expose
    private Double tempMax;
    @SerializedName("pressure")
    @Expose
    private Integer pressure;
    @SerializedName("humidity")
    @Expose
    private Integer humidity;


    public Main() {
    }

    public Main(Double temp, Double feels_like, Double tempMin, Double tempMax, Integer pressure, Integer humidity) {
        super();
        this.temp = temp;
        this.feels_like = feels_like;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getFeelsLike() {
        return feels_like;
    }

    public void setFeelsLike(Double feels_like) {
        this.feels_like = feels_like;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

}
