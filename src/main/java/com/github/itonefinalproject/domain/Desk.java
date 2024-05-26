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
@Table(name = "desk")
public class Desk extends AbstractEntity {
    @Column(name = "desk_name")
    private String name;
    @OneToMany(mappedBy = "desk", fetch = FetchType.LAZY)
    private List<Card> cards;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "desk_employee",
            joinColumns = {@JoinColumn(name = "desk_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "id")}
    )
    private List<Employee> employees;
}
