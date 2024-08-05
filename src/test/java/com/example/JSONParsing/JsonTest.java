package com.example.JSONParsing;

import com.example.JSONParsing.pojo.Author;
import com.example.JSONParsing.pojo.Book;
import com.example.JSONParsing.pojo.Day;
import com.example.JSONParsing.pojo.SimpleJsonPOJO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonTest {

    private String simpleTestCaseJsonSource =  "{\n" +
            "  \"title\": \"Json parsing\",\n" +
            "  \"author\": \"Chengwen\"\n" +
            "}";

    private String dayScenario1 = "{\n" +
            "  \"date\": \"2022-06-29\",\n" +
            "  \"name\": \"Birthday\"\n" +
            "}";

    private String authorBookScenario = "{\n" +
            "  \"authorName\": \"Chengwen\",\n" +
            "  \"books\": [\n" +
            "    {\n" +
            "      \"title\": \"Java expert\",\n" +
            "      \"inPrint\": true,\n" +
            "      \"publishDate\": \"2022-06-01\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Python expert\",\n" +
            "      \"inPrint\": false,\n" +
            "      \"publishDate\": \"2022-01-01\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    @Test
    void parse() throws IOException {
        JsonNode node = JsonUtil.parse(simpleTestCaseJsonSource);
        assertEquals("Json parsing", node.get("title").asText());
    }

    @Test
    void fromJson() throws IOException{

        JsonNode node = JsonUtil.parse(simpleTestCaseJsonSource);
        SimpleJsonPOJO pojo =  JsonUtil.fromJson(node, SimpleJsonPOJO.class);

        System.out.println("POJO title: " + pojo.getTitle());
        assertEquals("Json parsing", pojo.getTitle());
    }

    @Test
    void toJson() {
        SimpleJsonPOJO pojo = new SimpleJsonPOJO();
        pojo.setTitle("Json parsing exercise");

        JsonNode node = JsonUtil.toJson(pojo);

        assertEquals("Json parsing exercise", node.get("title").asText());
    }

    @Test
    void stringify() throws JsonProcessingException {
        SimpleJsonPOJO pojo = new SimpleJsonPOJO();
        pojo.setTitle("Json parsing exercise");

        JsonNode node = JsonUtil.toJson(pojo);

        System.out.println(JsonUtil.stringify(node));
        System.out.println("");
        System.out.println(JsonUtil.stringifyPretty(node));
    }

    @Test
    void dayTestScenario1() throws IOException{

        JsonNode node = JsonUtil.parse(dayScenario1);
        Day pojo =  JsonUtil.fromJson(node, Day.class);

        System.out.println("POJO date: " + pojo.getDate());
        assertEquals("2022-06-29", pojo.getDate().toString());
    }

    @Test
    void authorBookScenario() throws IOException{

        JsonNode node = JsonUtil.parse(authorBookScenario);
        Author pojo =  JsonUtil.fromJson(node, Author.class);

        System.out.println("Author: " + pojo.getAuthorName());
        for (Book bP : pojo.getBooks()) {
            System.out.println("Book: " + bP.getTitle());
            System.out.println("In print: " + bP.isInPrint());
            System.out.println("Date: " + bP.getPublishDate());
        }
    }

}