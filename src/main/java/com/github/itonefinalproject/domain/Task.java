package com.github.itonefinalproject.domain;

import com.github.itonefinalproject.domain.enums.KindOfTaskEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "task")
@Data
public class Task extends AbstractEntity {
    @Column(name = "kind_of_task")
    @Enumerated(EnumType.STRING)
    private List<KindOfTaskEnum> kindOfTaskEnum;

    @Column(name = "task_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    private Card card;

    @OneToMany
    private List<Employee> employees;
}
