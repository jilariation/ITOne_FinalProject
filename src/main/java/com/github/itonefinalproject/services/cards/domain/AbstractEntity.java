package com.github.itonefinalproject.services.cards.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Data
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id = UUID.randomUUID();

    @Column(name = "created", updatable = false)
    private LocalDateTime created;

    @Column(name = "updated", insertable = false)
    private LocalDateTime updated;

    @PrePersist
    public void toCreate() {
        setCreated(LocalDateTime.now());
    }

    @PreUpdate
    public void toUpdate() {
        setUpdated(LocalDateTime.now());
    }
}
