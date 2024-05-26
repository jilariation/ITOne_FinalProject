package com.github.itonefinalproject.repository;

import com.github.itonefinalproject.domain.Card;
import com.github.itonefinalproject.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


/**
 * Репозиторий для {@link Card}
 */
@Repository
public interface CardRepository extends JpaRepository<Card, UUID> {
}
