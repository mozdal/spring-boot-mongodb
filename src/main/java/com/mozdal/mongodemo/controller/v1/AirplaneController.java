package com.mozdal.mongodemo.controller.v1;


import com.mozdal.mongodemo.model.Airplane;
import com.mozdal.mongodemo.service.AirplaneService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/airplane")
@RestController
public class AirplaneController {

    @Autowired
    AirplaneService airplaneService;

    @GetMapping(value = "/get")
    public ResponseEntity getAllAirplanes() {
        try {
            List<Airplane> airplaneList = airplaneService.getAllAirplanes();
            return new ResponseEntity<>(airplaneList, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>("Error getting airplanes", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity getAirplaneById(@PathVariable("id") ObjectId id) {
        try {
            Airplane airplane =  airplaneService.getAirplaneById(id);
            return new ResponseEntity<>(airplane, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>("Error getting airpline with id: " + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/put/{id}")
    public ResponseEntity updateAirplane(@PathVariable("id") ObjectId id, @Valid @RequestBody Airplane airplane) {
        try {
            airplane.set_id(id);
            airplaneService.saveOrUpdateAirplane(airplane);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating airpline with id: " + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/save")
    public ResponseEntity createAirplane(@Valid @RequestBody Airplane airplane) {
        try {
            airplane.set_id(ObjectId.get());
            airplaneService.saveOrUpdateAirplane(airplane);
            return new ResponseEntity(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>("Error creating airplane", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteAirplaneById(@PathVariable ObjectId id) {
        try {
            airplaneService.deleteAirplaneWithId(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>("Error deleting airplane with id: " + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
