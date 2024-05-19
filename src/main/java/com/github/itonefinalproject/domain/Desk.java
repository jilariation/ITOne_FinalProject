package com.github.itonefinalproject.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "desk")
public class Desk extends AbstractEntity{
    @Column(name = "desk_name")
    private String name;
    @OneToMany(mappedBy = "desk")
    private List<Card> cards;
    @OneToMany(mappedBy = "desk")
    private List<Employee> employees;
}
