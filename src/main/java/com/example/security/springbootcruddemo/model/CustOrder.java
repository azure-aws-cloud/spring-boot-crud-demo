package com.example.security.springbootcruddemo.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cust_order")
public class CustOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ORDER_NBR")
    private Integer orderNumber;

    @Column(name = "SALE_PRICE")
    private BigDecimal salesPrice;

    @Column(name = "ORDER_DT")
    private LocalDateTime orderDate;

    @Column(name = "EXPECTED_SHIP_DT")
    private LocalDateTime expectedShipDate;

    @Column(name = "CANCELLED_DT")
    private LocalDateTime cancelledDate;

    @Column(name = "SHIP_DT")
    private LocalDateTime shipDate;

    @Column(name = "STATUS")
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUST_NBR")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMP_ID")
    private Employee employee;

    @OneToMany(mappedBy = "custOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineItem> lineItems = new ArrayList<>();

    // Getters / Setters
    public Integer getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public BigDecimal getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDateTime getExpectedShipDate() {
        return expectedShipDate;
    }

    public void setExpectedShipDate(LocalDateTime expectedShipDate) {
        this.expectedShipDate = expectedShipDate;
    }

    public LocalDateTime getCancelledDate() {
        return cancelledDate;
    }

    public void setCancelledDate(LocalDateTime cancelledDate) {
        this.cancelledDate = cancelledDate;
    }

    public LocalDateTime getShipDate() {
        return shipDate;
    }

    public void setShipDate(LocalDateTime shipDate) {
        this.shipDate = shipDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void addLineItem(LineItem li) {
        if (li == null) return;
        lineItems.add(li);
        li.setCustOrder(this);
    }

    public void removeLineItem(LineItem li) {
        if (li == null) return;
        lineItems.remove(li);
        li.setCustOrder(null);
    }
}
