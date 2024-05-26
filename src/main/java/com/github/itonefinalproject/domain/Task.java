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
@Table(name = "task")
public class Task extends AbstractEntity {
    @Column(name = "kind_of_task")
    private String kindOfTask;

    @Column(name = "task_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    private Card card;

    @ManyToMany(mappedBy = "tasks",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Employee> employees;
}
