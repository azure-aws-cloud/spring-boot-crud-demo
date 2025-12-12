package com.example.security.springbootcruddemo.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "job")
public class Job implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "JOB_ID")
    private Integer jobID;

    @Column(name = "FUNCTION")
    private String function;

    // Getters / Setters
    public Integer getJobID() {
        return this.jobID;
    }

    public void setJobID(Integer jobID) {
        this.jobID = jobID;
    }

    public String getFunction() {
        return this.function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
