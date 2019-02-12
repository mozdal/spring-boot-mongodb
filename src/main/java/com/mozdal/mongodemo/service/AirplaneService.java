package com.mozdal.mongodemo.service;

import com.mozdal.mongodemo.model.Airplane;
import com.mozdal.mongodemo.repository.AirplaneRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirplaneService {

    @Autowired
    AirplaneRepository airplaneRepository;

    public List<Airplane> getAllAirplanes() {
        return airplaneRepository.findAll();
    }

    public Airplane getAirplaneById(ObjectId id) {
        return airplaneRepository.findAirplaneBy_id(id);
    }

    public void saveOrUpdateAirplane(Airplane airplane) {
        airplaneRepository.save(airplane);
    }

    public void deleteAirplaneWithId(ObjectId id) {
        airplaneRepository.delete(airplaneRepository.findAirplaneBy_id(id));
    }
}
