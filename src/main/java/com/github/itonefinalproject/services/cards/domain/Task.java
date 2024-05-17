package com.github.itonefinalproject.services.cards.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "task")
@Data
public class Task extends AbstractEntity {
    @Enumerated
    @Column(name = "kind_of_task")
   private KindOfTaskEnum kindOfTaskEnum;
    @Column(name = "task_name")
   private String name;

    @ManyToOne
    @JoinColumn(referencedColumnName = "task_id")
   private Card card;
}
