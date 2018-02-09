package com.modu.api.openweather;


import org.junit.Test;

import com.modu.openweather.OpenWeatherMapService;
import com.modu.openweather.model.CurrentWeatherData;
import com.modu.openweather.model.ForecastWeatherData;

import org.junit.Assert;
import org.junit.BeforeClass;


public class OpenWeatherMapServiceTest {

    
    private static final double LATITUDE = 37.56667;
    private static final double LONGITUDE = 126.97806;

    private static OpenWeatherMapService openWeatherMapService;

    @BeforeClass
    public static void setUp() {
    		openWeatherMapService = new OpenWeatherMapService("01c7d8a477780af5f1a709813ae2b2b0");
    }

    
    @Test
    public void testGetWeatherByGeo() {
    		CurrentWeatherData currentWeatherInfo = openWeatherMapService.getCurrentWeatherByGeo(LATITUDE, LONGITUDE);
    		Assert.assertNotNull(currentWeatherInfo);
    		
    		System.out.println("현재날씨(위도, 경도) : " + currentWeatherInfo);    		
    }
    
    @Test
    public void testgetForecastWeatherByGeo() {
    		ForecastWeatherData forecastWeatherInfo = openWeatherMapService.getForecastWeatherByGeo(LATITUDE, LONGITUDE);        
    		Assert.assertNotNull(forecastWeatherInfo);
    		
    		System.out.println("미래날씨(위도, 경도) : " + forecastWeatherInfo);
    		
    }
   

}
