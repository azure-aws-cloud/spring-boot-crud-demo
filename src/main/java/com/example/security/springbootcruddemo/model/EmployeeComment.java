package com.example.security.springbootcruddemo.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employee_comment")
public class EmployeeComment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_COMMENT_ID")
    private Integer employeeCommentID;

    @Column(name = "TEXT")
    private String comment;

    public Integer getEmployeeCommentID() {
        return this.employeeCommentID;
    }

    public void setEmployeeCommentID(Integer employeeCommentID) {
        this.employeeCommentID = employeeCommentID;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
