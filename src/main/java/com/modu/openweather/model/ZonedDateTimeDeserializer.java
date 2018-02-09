package com.modu.openweather.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;


public final class ZonedDateTimeDeserializer extends JsonDeserializer<ZonedDateTime> {

    @Override
    public ZonedDateTime deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
    	
        JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);
        Instant instant = new Date(jsonNode.asLong() * 1000).toInstant();
        
        ZonedDateTime zoneDateTime = ZonedDateTime.ofInstant(instant, ZoneOffset.UTC);
        
        return zoneDateTime;
    }

}
