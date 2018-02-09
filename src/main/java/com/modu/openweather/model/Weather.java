package com.modu.openweather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Weather implements Serializable {

    @JsonProperty("coord")
    private Coord coord = new Coord();
    
    @JsonProperty("weather")
    private List<WeatherInfo> weathers = new ArrayList<WeatherInfo>();	
	
    @JsonProperty("main")
    private TemperatureInfo temperatureInfo;   
    
    @JsonProperty("wind")
    private WindInfo windInfo = new WindInfo();    
	
    @JsonProperty("clouds")
    private CloudInfo cloudInfo = new CloudInfo();
    
    @JsonProperty("rain")
    private PrecipitationInfo rainInfo = new PrecipitationInfo();
    
    @JsonProperty("snow")
    private PrecipitationInfo snowInfo = new PrecipitationInfo();
    
    @JsonProperty("dt")
    private ZonedDateTime dateTime;
    
    @JsonProperty("sys")
    private SysInfo sysInfo = new SysInfo();
    
    @JsonProperty("id")
    private int id;
    
    @JsonProperty("name")
    private String countryName;
    
    @JsonProperty("code")
    private int code;
    
    @JsonProperty("visibility")
    private int visibility;
    
    @JsonProperty("base")
    private String base;


    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class TemperatureInfo implements Serializable {

        @JsonProperty("temp")
        private Temperature temperature;
        
        @JsonProperty("temp_min")
        private Temperature minimalTemperature;
        
        @JsonProperty("temp_max")
        private Temperature maximalTemperature;

    }

    
    
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class WindInfo implements Serializable {

        @JsonProperty("speed")
        private double speed;
        
        @JsonProperty("deg")
        private double deg;

    }
    
    
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class PrecipitationInfo implements Serializable {

        @JsonProperty("3h")
        private double value;

        public double getValue() {
            return value;
        }

    }


    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class WeatherInfo implements Serializable {

        @JsonProperty("id")
        private int id;
        
        @JsonProperty("main")
        private String name;
        
        @JsonProperty("description")
        private String description;
        
        @JsonProperty("icon")
        private String icon;

    }


    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class CloudInfo implements Serializable {

        @JsonProperty("all")
        private int percentage;

    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class SysInfo implements Serializable {
    	
        @JsonProperty("type")
        private int type;
    
	    @JsonProperty("id")
	    private int id;
	    
	    @JsonProperty("message")
	    private double message;
	    
	    @JsonProperty("country")
	    private String country;
	    
	    @JsonProperty("sunrise")
	    private ZonedDateTime sunrise;
	    
	    @JsonProperty("sunset")
	    private ZonedDateTime sunset;

    }
    
}
