package com.example.mongo.controller;

import com.example.mongo.model.Hotel;
import com.example.mongo.repo.HotelRepositoryTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotels")
public class HotelController {

    private final HotelRepositoryTwo hotelRepositoryTwo;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public HotelController(HotelRepositoryTwo hotelRepositoryTwo, MongoTemplate mongoTemplate) {
        this.hotelRepositoryTwo = hotelRepositoryTwo;
        this.mongoTemplate = mongoTemplate;
    }

    @GetMapping("/all")
    public List<Hotel> getAllHotels() {
        return this.hotelRepositoryTwo.findAll();
    }

    @PostMapping
    public void saveHotel(@RequestBody Hotel hotel) {
        mongoTemplate.insert(hotel);
    }

    @PutMapping
    public void updateHotel(@RequestBody Hotel hotel) {
        mongoTemplate.save(hotel);
    }

    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable("id") String id) {
        this.hotelRepositoryTwo.deleteById(id);
    }

    @GetMapping("/{id}")
    public Hotel getHotelById(@PathVariable("id") String id) {
        return hotelRepositoryTwo.findById(id).orElseThrow();
    }

    @GetMapping("/findbyname/{name}")
    public List<Hotel> getHotelByName(@PathVariable("name") String name) {
//        Hotel hotel = mongoTemplate.findOne(Query.query(Criteria.where("name").is(name)), Hotel.class);
        return  hotelRepositoryTwo.findHotelsByName(name);
    }

    @GetMapping("/price/{maxPrice}")
    public List<Hotel> getByMaxPrice(@PathVariable("maxPrice") int maxPrice) {

        return hotelRepositoryTwo.findByPricePerNightLessThan(maxPrice);
    }

    @GetMapping("/pricebetween/minprice/{minPrice}/maxprice/{maxPrice}")
    public List<Hotel> getByPriceBetween(@PathVariable("minPrice") int minPrice, @PathVariable("maxPrice") int maxPrice) {
        return hotelRepositoryTwo.findByPricePerNightBetween(minPrice, maxPrice);
    }

    @GetMapping("/address/{city}")
    public List<Hotel> getByCity(@PathVariable("city") String city){
        List<Hotel> hotels = this.hotelRepositoryTwo.findByAddressCityIn(city);

        return hotels;
    }
}