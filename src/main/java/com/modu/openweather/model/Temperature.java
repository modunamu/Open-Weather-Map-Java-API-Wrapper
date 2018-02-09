package com.modu.openweather.model;

import java.io.Serializable;

import lombok.ToString;


@ToString
@SuppressWarnings("serial")
public final class Temperature implements Serializable {


    private double temperature;
    private TemperatureType temperatureType;
    
    enum TemperatureType { CELSIUS, KELVIN };
	

    public Temperature(final double temperature) {
    		this(temperature, TemperatureType.CELSIUS);
    }
    
    public Temperature(final double temperature, final TemperatureType type) {
    		
    		this.temperatureType = TemperatureType.CELSIUS;
    		
    		if( type.equals(TemperatureType.CELSIUS)) {
    			this.temperature = (double) Math.round((temperature - 273.15) * 100) / 100;    			
    		}
    	
    		if( type.equals(TemperatureType.KELVIN)) {
    			this.temperature = temperature + 273.15;			
    		}
    }

    public double getKelvin() {
        return this.temperature + 273.15;
    }

    public double getCelsius() {
        return this.temperature;
    }
    
    
}
