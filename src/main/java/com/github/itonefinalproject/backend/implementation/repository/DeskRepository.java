package com.github.itonefinalproject.backend.implementation.repository;

import com.github.itonefinalproject.domain.Desk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


/**
 * Репозиторий для {@link Desk}
 */
@Repository
public interface DeskRepository extends JpaRepository<Desk, UUID> {

}
