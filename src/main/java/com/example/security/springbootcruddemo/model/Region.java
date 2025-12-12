package com.example.security.springbootcruddemo.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "region")
public class Region implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REGION_ID")
    private Integer regionId;

    @Column(name = "SUPER_REGION_ID")
    private Integer superRegionID;

    @Column(name = "NAME")
    private String name;

    public Integer getRegionId() {
        return this.regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public Integer getSuperRegionID() {
        return this.superRegionID;
    }

    public void setSuperRegionID(Integer superRegionID) {
        this.superRegionID = superRegionID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
