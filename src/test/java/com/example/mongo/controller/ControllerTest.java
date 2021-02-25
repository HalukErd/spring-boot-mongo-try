package com.example.mongo.controller;

import com.example.mongo.model.Hotel;
import com.mysema.commons.lang.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class ControllerTest {

    @Test
    public void testGetByIdMethod() {
        String URI = "http://localhost:8080/api/v1/hotels/{id}";
        RestTemplate restTemplate = new RestTemplate();
        Hotel hotel = restTemplate.getForObject(URI, Hotel.class, "6034ccf9036f18025cd2d9c8");
    }
}
