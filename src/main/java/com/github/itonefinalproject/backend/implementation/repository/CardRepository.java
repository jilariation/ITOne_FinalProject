package com.github.itonefinalproject.backend.implementation.repository;

import com.github.itonefinalproject.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


/**
 * Репозиторий для {@link Card}
 */
@Repository
public interface CardRepository extends JpaRepository<Card, UUID> {}
