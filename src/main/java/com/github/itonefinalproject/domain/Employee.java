package com.github.itonefinalproject.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee extends AbstractEntity {
    @Column(name = "employee_name")
    private String name;
    @Column(name = "employee_email")
    private String email;
    @Column(name = "employee_password")
    private String password;

    @ManyToMany(mappedBy = "employees", fetch = FetchType.LAZY)
    private List<Desk> desks;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "task_employee",
            joinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "task_id", referencedColumnName = "id")}
    )
    private List<Task> tasks;
}