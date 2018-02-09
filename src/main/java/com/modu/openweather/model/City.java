package com.modu.openweather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;


@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class City implements Serializable {

    @JsonProperty("id")
    private int id;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("coord")
    private Coord coord;
    
    @JsonProperty("country")
    private String country;
    
    @JsonProperty("population")
    private int population;
    
}
