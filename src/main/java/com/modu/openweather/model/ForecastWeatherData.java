package com.modu.openweather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ForecastWeatherData implements Serializable {

    @JsonProperty("city")
    private City city;
    
    @JsonProperty("list")
    private List<Weather> weathers = new ArrayList<Weather>();

}
