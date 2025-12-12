package com.example.security.springbootcruddemo.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class OrdersId implements Serializable {

    @Embedded
    private MonthsId monthsId;

    public OrdersId() {}

    public OrdersId(MonthsId monthsId) {
        this.monthsId = monthsId;
    }

    public void setMonthsId(MonthsId monthsId) {
        this.monthsId = monthsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrdersId)) return false;
        OrdersId that = (OrdersId) o;
        return Objects.equals(monthsId, that.monthsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(monthsId);
    }
}

