package com.example.security.springbootcruddemo.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "months")
public class Months implements Serializable {

    @EmbeddedId
    private MonthsId id;

    public Months() {}

    public Months(MonthsId id) {
        this.id = id;
    }

    public MonthsId getId() {
        return id;
    }

    public void setId(MonthsId id) {
        this.id = id;
    }
}
