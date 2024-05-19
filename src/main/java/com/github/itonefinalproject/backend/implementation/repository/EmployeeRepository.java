package com.github.itonefinalproject.backend.implementation.repository;

import com.github.itonefinalproject.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


/**
 * Репозиторий для {@link Employee}
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
