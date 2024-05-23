package com.github.itonefinalproject.implementation.repository;

import com.github.itonefinalproject.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


/**
 * Репозиторий для {@link Task}
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
}
