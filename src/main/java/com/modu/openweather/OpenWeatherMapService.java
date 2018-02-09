package com.modu.openweather;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.modu.openweather.model.CurrentWeatherData;
import com.modu.openweather.model.CurrentWeatherDataDeserializer;
import com.modu.openweather.model.ForecastWeatherData;
import com.modu.openweather.model.Temperature;
import com.modu.openweather.model.TemperatureDeserializer;
import com.modu.openweather.model.ZonedDateTimeDeserializer;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.time.ZonedDateTime;



public class OpenWeatherMapService {

    private static final String VERSION = "2.5";
    private static final String API_URL = "http://api.openweathermap.org/data/";

    private final String apiKey;
    private final OpenWeatherMapInterface openWeatherMapInterface;    

    public OpenWeatherMapService(String apiKey) {
        this(apiKey, VERSION);
    }

    public OpenWeatherMapService(String apiKey, String apiVersion) {
    	
        this.apiKey = apiKey;

        SimpleModule simpleModule = new SimpleModule();
        ObjectMapper objectMapper = new ObjectMapper();        
        
        simpleModule.addDeserializer(ZonedDateTime.class, new ZonedDateTimeDeserializer());
        simpleModule.addDeserializer(Temperature.class, new TemperatureDeserializer());        
        simpleModule.addDeserializer(CurrentWeatherData.class, new CurrentWeatherDataDeserializer(objectMapper));
        
        objectMapper.registerModule(simpleModule);

        openWeatherMapInterface = new Retrofit.Builder()
                .baseUrl(API_URL + apiVersion + "/")
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .build()
                .create(OpenWeatherMapInterface.class);
    }

    
    public CurrentWeatherData getCurrentWeatherByGeo(double latitude, double longitude) {
    	
        try {
        	
            Call<CurrentWeatherData> call = openWeatherMapInterface.getCurrentWeatherByGeo(apiKey, latitude, longitude);
            return call.execute().body();
            
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        
    }   
    
	public ForecastWeatherData getForecastWeatherByGeo(double latitude, double longitude) {
		
		try {
		    	
			Call<ForecastWeatherData> call = openWeatherMapInterface.getForecastWeatherByGeo(apiKey, latitude, longitude);
			return call.execute().body();
		        
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	    
	}
    
    

}