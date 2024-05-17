package com.github.itonefinalproject.services.cards.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "employee")
public class Employee extends AbstractEntity {
    @Column(name = "employee_name")
    private String name;
    @Column(name = "employee_email")
    private String email;
    @Column(name = "employee_name")
    private String password;

    @ManyToOne
    @JoinColumn(referencedColumnName = "employee_id")
    private Card card;

    @ManyToOne
    @JoinColumn(referencedColumnName = "employee_id")
    private Desk desk;
}
