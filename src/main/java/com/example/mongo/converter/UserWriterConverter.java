package com.example.mongo.converter;

import com.example.mongo.model.Hotel;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;

@WritingConverter
@ReadingConverter
public class UserWriterConverter implements Converter<Hotel, DBObject> {
    @Override
    public DBObject convert(final Hotel hotel) {
        DBObject dbObject = new BasicDBObject();
//        dbObject.put("name", hotel.getPricePerNight());
//        dbObject.put("pricePerNnnight", hotel.getName());
//        if (hotel.getAddress() != null) {
//            DBObject addressDbObject = new BasicDBObject();
//            addressDbObject.put("city", hotel.getAddress().getCity());
//            addressDbObject.put("country", hotel.getAddress().getCountry());
//            dbObject.put("address", addressDbObject);
//        }
//        if (hotel.getReviews() != null) {
//            hotel.getReviews().forEach(
//                    review -> {
//                        DBObject reviewDbObject = new BasicDBObject();
//                        reviewDbObject.put("userName", review.getUserName());
//                        reviewDbObject.put("rating", review.getRating());
//                        reviewDbObject.put("approved", review.isApproved());
//                        dbObject.put("reviews", reviewDbObject);
//                    }
//            );
//        }
//
//        dbObject.put("reviewsTry", hotel.getReviews());
        return dbObject;

    }

}
