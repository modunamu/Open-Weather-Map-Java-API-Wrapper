package com.modu.openweather.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;


public final class TemperatureDeserializer extends JsonDeserializer<Temperature> {

    @Override
    public Temperature deserialize(final JsonParser jsonParser, final DeserializationContext context) throws IOException {

    		JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);
    		
    		Temperature temperature = new Temperature(jsonNode.numberValue().doubleValue());
    		
        return temperature;
        
    }

}
