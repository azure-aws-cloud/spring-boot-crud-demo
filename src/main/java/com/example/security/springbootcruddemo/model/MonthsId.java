package com.example.security.springbootcruddemo.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MonthsId implements Serializable {

    @Column(name = "month_val")   // avoid reserved keyword
    private Integer month;

    @Column(name = "year_val")
    private Integer year;

    public MonthsId() {}

    public MonthsId(Integer month, Integer year) {
        this.month = month;
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MonthsId)) return false;
        MonthsId that = (MonthsId) o;
        return Objects.equals(month, that.month)
                && Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, year);
    }
}
