package com.github.itonefinalproject.services.cards.domain;

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
    String name;
    @OneToMany(mappedBy = "desk")
    List<Card> cards;
    @OneToMany(mappedBy = "desk")
    List<Employee> employees;
}
