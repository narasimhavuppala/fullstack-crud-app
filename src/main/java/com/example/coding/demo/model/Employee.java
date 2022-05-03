package com.example.coding.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;

    @Min(1000)
    private double salary;

    @PastOrPresent
    @Temporal(TemporalType.DATE)
    private Date joiningDate;
    @NotBlank
    private String role;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date modifiedDate;

    @PrePersist
    public void prePersist() {
        createdDate = new Date();
        modifiedDate = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        modifiedDate = new Date();
    }

}
