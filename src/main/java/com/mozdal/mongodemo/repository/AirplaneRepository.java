package com.mozdal.mongodemo.repository;

import com.mozdal.mongodemo.model.Airplane;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AirplaneRepository extends MongoRepository<Airplane, String> {

    Airplane findAirplaneBy_id(ObjectId _id);

    List<Airplane> findAirplanesBy_idBetween(ObjectId start, ObjectId end);

}
