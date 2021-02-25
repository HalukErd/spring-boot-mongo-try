package com.example.mongo;

import com.example.mongo.model.Address;
import com.example.mongo.model.Hotel;
import com.example.mongo.model.Review;
import com.example.mongo.repo.HotelRepositoryTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    private HotelRepositoryTwo hotelRepositoryTwo;

    @Autowired
    private MongoOperations mongoOperations;

    @Autowired
    public DbSeeder(HotelRepositoryTwo hotelRepositoryTwo) {
        this.hotelRepositoryTwo = hotelRepositoryTwo;
    }

    @Override
    public void run(String... args) throws Exception {
        Hotel grandBudapest = new Hotel(
                "GrandBudapest",
                500,
                new Address("Budapest", "Wes"),
                Arrays.asList(
                        new Review("Haluk", 10, true),
                        new Review("Sarp", 8, false)
                )
        );

        Hotel ibis = new Hotel(
                "Ibis",
                90,
                new Address("Bucharest", "Romania"),
                Arrays.asList(
                        new Review("Teddy", 9, true)
                )
        );

        Hotel sofitel = new Hotel(
                "Sofitel",
                200,
                new Address("Rome", "Italy"),
                new ArrayList<>()
        );
        Hotel newH = new Hotel(
                "newH",
                300,
                new Address("Rome", "Italy"),
                new ArrayList<>()
        );

        this.hotelRepositoryTwo.deleteAll();


        List<Hotel> hotels = Arrays.asList(grandBudapest, ibis, sofitel, newH);
        hotelRepositoryTwo.saveAll(hotels);
//        mongoOperations.insert(grandBudapest);
//        mongoOperations.insert(ibis);
//        mongoOperations.insert(sofitel);
//        mongoOperations.insert(newH);
    }
}