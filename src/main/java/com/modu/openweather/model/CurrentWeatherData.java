package com.modu.openweather.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
public final class CurrentWeatherData implements Serializable {
    
    private City city;
    
    private Weather weatherInfo;

}
