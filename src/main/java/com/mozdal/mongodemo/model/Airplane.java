package com.mozdal.mongodemo.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Airplane {
    @Id
    @Getter(AccessLevel.NONE)
    public ObjectId _id;

    public String manufacturer;
    public String model;
    public String tailNumber;
    public String capacity;

    // Constructors
    public Airplane() {}

    public Airplane(ObjectId _id, String manufacturer, String model, String tailNumber, String capacity) {
        this._id = _id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.tailNumber = tailNumber;
        this.capacity = capacity;

    }

    // ObjectId needs to be converted to string
    public String get_id() { return _id.toHexString(); }
}
