package com.pricing.infrastructure.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        // Registrar el módulo para manejar tipos de fecha y hora de Java 8
        objectMapper.registerModule(new JavaTimeModule());
    }

    public static String convertToJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{}"; // Retorna un objeto JSON vacío en caso de error
        }
    }
}
