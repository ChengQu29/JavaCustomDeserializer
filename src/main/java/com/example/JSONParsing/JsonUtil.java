package com.example.JSONParsing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;

public class JsonUtil {

    private static ObjectMapper objectMapper = getDefaultObjectMapper();

    private static ObjectMapper getDefaultObjectMapper() {
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        defaultObjectMapper.registerModule(new JavaTimeModule());
        defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return defaultObjectMapper;
    }

    public static JsonNode parse(String src) throws IOException {

        return objectMapper.readTree(src);
    }

    //Deserialize
    public static <A> A fromJson(JsonNode node, Class<A> clazz) throws JsonProcessingException{
        return objectMapper.treeToValue(node, clazz);
    }

    //Serialize
    public static JsonNode toJson(Object a) {
        return objectMapper.valueToTree(a);
    }

    public static String stringify(JsonNode node) throws JsonProcessingException {
        return generatePrint(node, false);
    }

    public static String stringifyPretty(JsonNode node) throws JsonProcessingException {
        return generatePrint(node, true);
    }

    public static String generatePrint(JsonNode node, boolean isPretty) throws JsonProcessingException{
        ObjectWriter objectWriter = objectMapper.writer();
        if (isPretty) {
            objectWriter= objectWriter.with(SerializationFeature.INDENT_OUTPUT);
        }
        return objectWriter.writeValueAsString(node);
    }
}
