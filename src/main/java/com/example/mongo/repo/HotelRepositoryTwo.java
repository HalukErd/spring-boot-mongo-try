package com.example.mongo.repo;

import com.example.mongo.model.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepositoryTwo extends MongoRepository<Hotel, String>{
    Optional<Hotel> findById(String id);
    List<Hotel> findByPricePerNightLessThan(int maxPrice);

    List<Hotel> findByAddressCityIn(String city);

    @Query("{ 'name' : ?0 }")
    List<Hotel> findHotelsByName(String name);

    @Query("{ 'pricePerNight' : { $gt: ?0, $lt: ?1 } }")
    List<Hotel> findByPricePerNightBetween(int priceGT, int priceLT);

    @Query("{ 'name' : { $regex: ?0 } }")
    List<Hotel> findHotelsByRegexpName(String regexp);
//
//    List<Hotel> findByName(String name);
//
//    List<Hotel> findByNameLikeOrderByAgeAsc(String name);
//
//    List<Hotel> findByAgeBetween(int ageGT, int ageLT);
//
//    List<Hotel> findByNameStartingWith(String regexp);
//
//    List<Hotel> findByNameEndingWith(String regexp);
//
//    @Query(value = "{}", fields = "{name : 1}")
//    List<Hotel> findNameAndId();
//
//    @Query(value = "{}", fields = "{_id : 0}")
//    List<Hotel> findNameAndAgeExcludeId();
}