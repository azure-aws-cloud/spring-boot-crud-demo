package com.example.security.springbootcruddemo.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUST_NBR")
    private Integer customerId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TOT_ORDERS")
    private Integer totalOrders;

    @Column(name = "LAST_ORDER_DT")
    private LocalDateTime lastOrderDate;

    @Column(name = "INACTIVE_DT")
    private LocalDateTime inactiveDate;

    @Column(name = "INACTIVE_IND")
    private String inactiveInd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGION_ID")
    private Region region;

    // Getters / Setters
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(Integer totalOrders) {
        this.totalOrders = totalOrders;
    }

    public LocalDateTime getLastOrderDate() {
        return lastOrderDate;
    }

    public void setLastOrderDate(LocalDateTime lastOrderDate) {
        this.lastOrderDate = lastOrderDate;
    }

    public LocalDateTime getInactiveDate() {
        return inactiveDate;
    }

    public void setInactiveDate(LocalDateTime inactiveDate) {
        this.inactiveDate = inactiveDate;
    }

    public String getInactiveInd() {
        return inactiveInd;
    }

    public void setInactiveInd(String inactiveInd) {
        this.inactiveInd = inactiveInd;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
