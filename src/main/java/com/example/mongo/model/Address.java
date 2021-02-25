package com.example.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Address {
    @Id
    private String id;
    private String city;
    private String country;

    protected Address(){}

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
