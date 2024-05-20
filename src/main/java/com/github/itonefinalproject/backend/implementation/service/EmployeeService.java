package com.github.itonefinalproject.backend.implementation.service;

import com.github.itonefinalproject.backend.implementation.repository.EmployeeRepository;
import com.github.itonefinalproject.domain.Employee;
import com.github.itonefinalproject.backend.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Сервис для {@link Employee}
 */
@Service
@RequiredArgsConstructor
public class EmployeeService extends AbstractService<Employee> {
    private final EmployeeRepository employeeRepository;
    private final DeskService deskService;
    @Override
    @Transactional
    public void createEntity(Employee entity) {
        employeeRepository.save(entity);
    }

    @Override
    @Transactional
    public Employee findById(UUID id) {
        return employeeRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public void updateEntity(UUID id, Employee updatedEntity) {
        updatedEntity.setId(id);
        employeeRepository.save(updatedEntity);
    }

    @Override
    @Transactional
    public void deleteEntity(UUID id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Transactional
    public void addEmployee(UUID deskId, Employee employee) {
        enrichEmployee(employee, deskId);
        employeeRepository.save(employee);
    }

    @Transactional
    public void updateEmployee(UUID employeeId, UUID deskId, Employee updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow();
        employee.setName(updatedEmployee.getName());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setPassword(updatedEmployee.getPassword());
        employee.setUpdated(LocalDateTime.now());
        addEmployee(deskId, employee);
    }

    private void enrichEmployee(Employee employee, UUID deskId) {
        employee.setDesk(deskService.findById(deskId));
    }
}