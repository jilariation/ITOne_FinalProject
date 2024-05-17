package com.github.itonefinalproject.services.cards.backend.implementation.repository;

import com.github.itonefinalproject.services.base.DatabaseQuery;
import com.github.itonefinalproject.services.cards.backend.repository.AbstractRepository;
import com.github.itonefinalproject.services.cards.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.UUID;

import static com.github.itonefinalproject.services.base.DatabaseConfig.getPreparedStatement;

/**
 * Репозиторий для {@link Task}
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
}
