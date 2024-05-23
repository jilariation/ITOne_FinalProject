package com.github.itonefinalproject.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "desk")
public class Desk extends AbstractEntity {
    @Column(name = "desk_name")
    private String name;
    @OneToMany(mappedBy = "desk")
    private List<Card> cards;
    @ManyToMany(mappedBy = "desk")
    private List<Employee> employees;
}
