package com.modu.openweather;


import com.modu.openweather.model.CurrentWeatherData;
import com.modu.openweather.model.ForecastWeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


interface OpenWeatherMapInterface {

	
    @GET("weather?mode=json")
    Call<CurrentWeatherData> getCurrentWeatherByGeo(@Query("apikey") String apiKey, @Query("lat") double latitude, @Query("lon") double longitude);


    @GET("forecast?mode=json")
    Call<ForecastWeatherData> getForecastWeatherByGeo(@Query("apiKey") String apiKey, @Query("lat") double latitude, @Query("lon") double longitude);

}