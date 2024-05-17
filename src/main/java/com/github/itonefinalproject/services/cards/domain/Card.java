package com.github.itonefinalproject.services.cards.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Table(name = "card")
@Data
@EqualsAndHashCode(callSuper = true)
public class Card extends AbstractEntity {
    @Column(name = "card_name")
    private String name;

    @OneToMany(mappedBy = "card")
    private List<Task> tasks;
    @OneToMany(mappedBy = "card")
    private List<Employee> employees;

    @ManyToOne
    @JoinColumn(referencedColumnName = "card_id")
    private Desk desk;
}
