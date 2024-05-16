package com.github.itonefinalproject.services.cards.backend.implementation.service;

import com.github.itonefinalproject.services.cards.backend.implementation.repository.EmployeeRepository;
import com.github.itonefinalproject.services.cards.backend.service.AbstractService;
import com.github.itonefinalproject.services.cards.domain.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Сервис для {@link Employee}
 */
@Service
@RequiredArgsConstructor
public class EmployeeService extends AbstractService<Employee> {
    private final EmployeeRepository employeeRepository;
    @Override
    public void createEntity(Employee entity) {
        employeeRepository.createEntity(entity);
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void updateEntity(Integer id, Employee updatedEntity) {
        employeeRepository.updateEntity(id, updatedEntity);
    }

    @Override
    public void deleteEntity(Integer id) {
        employeeRepository.deleteEntity(id);
    }
}