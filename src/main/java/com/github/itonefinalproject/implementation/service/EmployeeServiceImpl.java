package com.github.itonefinalproject.implementation.service;

import com.github.itonefinalproject.dto.employee.CreateEmployeeDto;
import com.github.itonefinalproject.dto.employee.EmployeeRequest;
import com.github.itonefinalproject.dto.employee.EmployeeResponse;
import com.github.itonefinalproject.repository.EmployeeRepository;
import com.github.itonefinalproject.domain.Employee;
import com.github.itonefinalproject.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Сервис для {@link Employee}
 */
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeResponse createEntity(CreateEmployeeDto entityDto) {
        return null;
    }

    @Override
    public EmployeeResponse findById(UUID id) {
        return null;
    }

    @Override
    public EmployeeResponse updateEntity(UUID id, EmployeeRequest updatedEntityDto) {
        return null;
    }

    @Override
    public void deleteEntity(UUID id) {

    }

    @Override
    public List<EmployeeResponse> findAll() {
        return null;
    }

    @Override
    public List<EmployeeResponse> getEmployeesById(List<UUID> uuid) {
        return null;
    }
//    @Override
//    @Transactional
//    public void createEntity(Employee entity) {
//        employeeRepository.save(entity);
//    }
//
//    @Override
//    @Transactional
//    public Employee findById(UUID id) {
//        return employeeRepository.findById(id).orElseThrow();
//    }
//
//    @Override
//    @Transactional
//    public void updateEntity(UUID id, Employee updatedEntity) {
//        updatedEntity.setId(id);
//        employeeRepository.save(updatedEntity);
//    }
//
//    @Override
//    @Transactional
//    public void deleteEntity(UUID id) {
//        employeeRepository.deleteById(id);
//    }
//
//    public List<Employee> findAll() {
//        return employeeRepository.findAll();
//    }
//
//    @Transactional
//    public void addEmployee(UUID deskId, Employee employee) {
//        enrichEmployee(employee, deskId);
//        employeeRepository.save(employee);
//    }
//
//    @Transactional
//    public void updateEmployee(UUID employeeId, UUID deskId, Employee updatedEmployee) {
//        Employee employee = employeeRepository.findById(employeeId).orElseThrow();
//        employee.setName(updatedEmployee.getName());
//        employee.setEmail(updatedEmployee.getEmail());
//        employee.setPassword(updatedEmployee.getPassword());
//        employee.setUpdated(LocalDateTime.now());
//        addEmployee(deskId, employee);
//    }
//
//    private void enrichEmployee(Employee employee, UUID deskId) {
//        employee.setDesk(deskService.findById(deskId));
//    }
}