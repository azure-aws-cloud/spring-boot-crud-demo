package com.example.security.springbootcruddemo.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "line_item")
public class LineItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private LineItemId id = new LineItemId();

    @Column(name = "QTY")
    private Integer qty;

    @Column(name = "FILLED_QTY")
    private Integer filledQty;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("partNumber")
    @JoinColumn(name = "PART_NBR")
    private Part part;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("orderNumber")
    @JoinColumn(name = "ORDER_NBR")
    private CustOrder custOrder;

    // Getters / Setters
    public LineItemId getId() {
        return id;
    }

    public void setId(LineItemId id) {
        this.id = id;
    }

    public Integer getQty() {
        return this.qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getFilledQty() {
        return this.filledQty;
    }

    public void setFilledQty(Integer filledQty) {
        this.filledQty = filledQty;
    }

    public Part getPart() {
        return this.part;
    }

    public void setPart(Part part) {
        this.part = part;
        if (part != null) {
            this.id.setPartNumber(part.getPartNumber());
        }
    }

    public CustOrder getCustOrder() {
        return this.custOrder;
    }

    public void setCustOrder(CustOrder custOrder) {
        this.custOrder = custOrder;
        if (custOrder != null) {
            this.id.setOrderNumber(custOrder.getOrderNumber());
        }
    }
}
