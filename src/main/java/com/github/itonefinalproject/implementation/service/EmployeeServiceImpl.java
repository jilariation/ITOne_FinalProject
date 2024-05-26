package com.github.itonefinalproject.implementation.service;

import com.github.itonefinalproject.dto.employee.CreateEmployeeDto;
import com.github.itonefinalproject.dto.employee.EmployeeRequest;
import com.github.itonefinalproject.dto.employee.EmployeeResponse;
import com.github.itonefinalproject.mapper.EmployeeModelMapper;
import com.github.itonefinalproject.repository.EmployeeRepository;
import com.github.itonefinalproject.domain.Employee;
import com.github.itonefinalproject.service.EmployeeService;
import com.github.itonefinalproject.service.EntityFinderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Сервис для {@link Employee}
 */
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeModelMapper employeeModelMapper;


    @Override
    public EmployeeResponse createEntity(CreateEmployeeDto entityDto) {
        Employee employee = employeeModelMapper.toEntity(entityDto);
        employeeRepository.save(employee);
        return employeeModelMapper.toDto(employee);
    }

    @Override
    public EmployeeResponse findById(UUID id) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        return employeeModelMapper.toDto(employee);
    }

    @Override
    public EmployeeResponse updateEntity(UUID id, EmployeeRequest updatedEntityDto) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        employeeModelMapper.toEntity(employee, updatedEntityDto);
        employeeRepository.save(employee);
        return employeeModelMapper.toDto(employee);
    }

    @Override
    public void deleteEntity(UUID id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeResponse> findAll() {
        return employeeRepository.findAll().stream()
                .map(employeeModelMapper::toDto)
                .collect(Collectors.toList());
    }
}