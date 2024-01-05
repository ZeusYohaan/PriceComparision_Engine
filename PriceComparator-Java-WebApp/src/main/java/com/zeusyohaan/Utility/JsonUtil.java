package com.zeusyohaan.Utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil<T> {
    private ObjectMapper objectMapper = new ObjectMapper();
    public String toJson(T object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    public T fromJson(String json, Class<T> type) throws JsonProcessingException {
        return objectMapper.readValue(json, type);
    }

    public T fromJsonMap(String json, TypeReference<T> typeReference) throws JsonProcessingException {
        return objectMapper.readValue(json, typeReference);
    }

}