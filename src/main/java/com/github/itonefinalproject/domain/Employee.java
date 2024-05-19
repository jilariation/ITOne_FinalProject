package com.github.itonefinalproject.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "employee")
public class Employee extends AbstractEntity {
    @Column(name = "employee_name")
    private String name;
    @Column(name = "employee_email")
    private String email;
    @Column(name = "employee_password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "desk_id", referencedColumnName = "id")
    private Desk desk;
}
