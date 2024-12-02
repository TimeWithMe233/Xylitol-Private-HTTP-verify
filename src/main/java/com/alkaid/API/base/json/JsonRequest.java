package com.alkaid.API.base.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class JsonRequest {
    public static String extractData(String json, String key) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map<String, Object> responseMap = objectMapper.readValue(json, Map.class);
            if (responseMap.containsKey(key)) {
                return (String) responseMap.get(key);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
    public static int extractIntData(int json, String key) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map<String, Object> responseMap = objectMapper.readValue(String.valueOf(json), Map.class);
            if (responseMap.containsKey(key)) {
                return (Integer) responseMap.get(key);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return -1;
    }
}
