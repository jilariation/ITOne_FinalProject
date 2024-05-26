package com.github.itonefinalproject.repository;

import com.github.itonefinalproject.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


/**
 * Репозиторий для {@link Employee}
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    /**
     * Находит все {@link Employee} по List из uuid
     * @param uuids List с uuid
     * @return Возращает List с {@link Employee}
     */
    List<Employee> findByIdIn(List<UUID> uuids);
}
