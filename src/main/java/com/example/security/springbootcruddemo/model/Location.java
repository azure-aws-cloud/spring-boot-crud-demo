package com.example.security.springbootcruddemo.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "location")
public class Location implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOCATION_ID")
    private Integer locationID;

    @Column(name = "REGIONAL_GROUP")
    private String regionalGroup;

    public Integer getLocationID() {
        return this.locationID;
    }

    public void setLocationID(Integer locationID) {
        this.locationID = locationID;
    }

    public String getRegionalGroup() {
        return this.regionalGroup;
    }

    public void setRegionalGroup(String regionalGroup) {
        this.regionalGroup = regionalGroup;
    }
}
