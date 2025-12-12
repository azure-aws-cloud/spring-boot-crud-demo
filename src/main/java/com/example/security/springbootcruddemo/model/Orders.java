package com.example.security.springbootcruddemo.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orders")
public class Orders implements Serializable {

    @EmbeddedId
    private OrdersId id;

    @ManyToOne
    @MapsId("monthsId")   // <-- Reuse columns from the embedded ID
    @JoinColumns({
            @JoinColumn(name = "month_val", referencedColumnName = "month_val"),
            @JoinColumn(name = "year_val", referencedColumnName = "year_val")
    })
    private Months months;

    // Example fields (add your own)
    @Column(name = "order_desc")
    private String orderDesc;

    public Orders() {}

    public Orders(OrdersId id, String orderDesc) {
        this.id = id;
        this.orderDesc = orderDesc;
    }

    public OrdersId getId() {
        return id;
    }

    public void setId(OrdersId id) {
        this.id = id;
    }

    public Months getMonths() {
        return months;
    }

    public void setMonths(Months months) {
        this.months = months;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }
}
