package com.github.itonefinalproject.backend.implementation.service;

import com.github.itonefinalproject.backend.implementation.repository.EmployeeRepository;
import com.github.itonefinalproject.domain.Employee;
import com.github.itonefinalproject.backend.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Сервис для {@link Employee}
 */
@Service
@RequiredArgsConstructor
public class EmployeeService extends AbstractService<Employee> {
    private final EmployeeRepository employeeRepository;
    @Override
    public void createEntity(Employee entity) {
        employeeRepository.save(entity);
    }

    @Override
    public Employee findById(UUID id) {
        return employeeRepository.findById(id).orElseThrow();
    }

    @Override
    public void updateEntity(UUID id, Employee updatedEntity) {
        updatedEntity.setId(id);
        employeeRepository.save(updatedEntity);
    }

    @Override
    public void deleteEntity(UUID id) {
        employeeRepository.deleteById(id);
    }
}