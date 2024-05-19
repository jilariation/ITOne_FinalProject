package com.github.itonefinalproject.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "task")
@Data
public class Task extends AbstractEntity {
    @Column(name = "kind_of_task")
    private KindOfTaskEnum kindOfTaskEnum;
    @Column(name = "task_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "card_id", referencedColumnName = "id")
   private Card card;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;
}
