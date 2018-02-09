package com.modu.openweather.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;


public final class CurrentWeatherDataDeserializer extends JsonDeserializer<CurrentWeatherData> {

    private ObjectMapper mapper;

    public CurrentWeatherDataDeserializer(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public CurrentWeatherData deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
        
    		JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);
    		
    		CurrentWeatherData currentWeatherData = deserialize(jsonNode);
    		
    		return currentWeatherData;
        
    }

    private CurrentWeatherData deserialize(JsonNode jsonNode) throws JsonProcessingException {
    	
        int id = jsonNode.get("id").numberValue().intValue();
        String country = jsonNode.get("sys").get("country").textValue();
        String name = jsonNode.get("name").textValue();
        int population = 0;
        
        Coord coordinates = mapper.treeToValue(jsonNode.get("coord"), Coord.class);

        Weather weatherInfo = mapper.treeToValue(jsonNode, Weather.class);
        City city = new City(id, name, coordinates, country, population);
        
        CurrentWeatherData currentWeatherData = new CurrentWeatherData(city, weatherInfo);
        
        return currentWeatherData;
    }

}
