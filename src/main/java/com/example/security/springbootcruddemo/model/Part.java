package com.example.security.springbootcruddemo.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "part")
public class Part implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PART_NBR")
    private String partNumber;

    @Column(name = "NAME")
    private String name;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "INVENTORY_QTY")
    private Integer inventoryQuantity;

    @Column(name = "UNIT_COST")
    private String unitCost;

    @Column(name = "RESUPPLY_DATE")
    private LocalDateTime resupplyDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUPPLIER_ID")
    private Supplier supplier;

    @OneToMany(mappedBy = "part", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineItem> lineItems = new ArrayList<>();

    // Getters / Setters
    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(Integer inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }

    public String getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(String unitCost) {
        this.unitCost = unitCost;
    }

    public LocalDateTime getResupplyDate() {
        return resupplyDate;
    }

    public void setResupplyDate(LocalDateTime resupplyDate) {
        this.resupplyDate = resupplyDate;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void addLineItem(LineItem li) {
        lineItems.add(li);
        li.setPart(this);
    }

    public void removeLineItem(LineItem li) {
        lineItems.remove(li);
        li.setPart(null);
    }
}
