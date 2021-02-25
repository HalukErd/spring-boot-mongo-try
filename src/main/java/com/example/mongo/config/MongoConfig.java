package com.example.mongo.config;

import com.example.mongo.converter.UserWriterConverter;
import com.example.mongo.event.HotelCascadeSaveMongoEventListener;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.mongo.repo")
public class MongoConfig extends AbstractMongoClientConfiguration {
    private final List<Converter<?, ?>> converters = new ArrayList<>();

    @Bean
    public MongoCustomConversions customConversions() {
        converters.add(new UserWriterConverter());

        return new MongoCustomConversions(converters);
    }

    @Override
    public MongoClient mongoClient() {
        String username = "halukerd";
        String password = "";
        String database = "newdb";

        final ConnectionString connectionString = new ConnectionString(
            String.format("mongodb+srv://%s:%s@cluster0.djwrk.mongodb.net/%s?retryWrites=true&w=majority",
                    username,
                    password,
                    database)
        );
        final MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public HotelCascadeSaveMongoEventListener userCascadingMongoEventListener() {
        return new HotelCascadeSaveMongoEventListener();
    }

    @Override
    protected String getDatabaseName() {
        return "newdb";
    }
}
