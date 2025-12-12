package com.example.security.springbootcruddemo.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "salesperson")
public class SalesPerson implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SALESPERSON_ID")
    private Integer salesPersonId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRIMARY_REGION_ID")
    private Integer primaryRegionID;

    public Integer getSalesPersonId() {
        return this.salesPersonId;
    }

    public void setSalesPersonId(Integer salesPersonId) {
        this.salesPersonId = salesPersonId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrimaryRegionID() {
        return this.primaryRegionID;
    }

    public void setPrimaryRegionID(Integer primaryRegionID) {
        this.primaryRegionID = primaryRegionID;
    }
}
