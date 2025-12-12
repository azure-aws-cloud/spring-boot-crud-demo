package com.example.security.springbootcruddemo.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LineItemId implements Serializable {

    @Column(name = "PART_NBR")
    private String partNumber;

    @Column(name = "ORDER_NBR")
    private Integer orderNumber;

    public LineItemId() {}

    public LineItemId(String partNumber, Integer orderNumber) {
        this.partNumber = partNumber;
        this.orderNumber = orderNumber;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LineItemId)) return false;
        LineItemId that = (LineItemId) o;
        return Objects.equals(partNumber, that.partNumber) &&
                Objects.equals(orderNumber, that.orderNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partNumber, orderNumber);
    }
}
