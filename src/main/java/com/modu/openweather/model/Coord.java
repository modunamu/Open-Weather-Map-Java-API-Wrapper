package com.modu.openweather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

import java.io.Serializable;


@SuppressWarnings("serial")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Coord implements Serializable {

    @JsonProperty("lon")
    private double longitude;
    
    @JsonProperty("lat")
    private double latitude;

}
