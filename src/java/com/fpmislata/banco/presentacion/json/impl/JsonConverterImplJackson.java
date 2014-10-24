

package com.fpmislata.banco.presentacion.json.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpmislata.banco.presentacion.json.JsonConverter;
import java.io.IOException;

public class JsonConverterImplJackson implements JsonConverter{

    @Override
    public String toJson(Object data) {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            
            return objectMapper.writeValueAsString(data);
        }catch(JsonProcessingException ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Object fromJson(String json, Class clazz) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, clazz);
        } catch(IOException ex){
            throw new RuntimeException(ex);
        
        }
    }
    
}
