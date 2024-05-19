package com.github.itonefinalproject.domain;

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

    @ManyToOne
    @JoinColumn(name = "desk_id", referencedColumnName = "id")
    private Desk desk;
}
