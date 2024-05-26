package com.github.itonefinalproject.mapper;

import com.github.itonefinalproject.domain.Employee;
import com.github.itonefinalproject.dto.employee.CreateEmployeeDto;
import com.github.itonefinalproject.dto.employee.EmployeeRequest;
import com.github.itonefinalproject.dto.employee.EmployeeResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class EmployeeModelMapper extends AbstractModelMapper<Employee, EmployeeResponse> {
    private final ModelMapper modelMapper;

    @Override
    public Employee toEntity(EmployeeResponse dto) {
        return null;
    }

    @Override
    public EmployeeResponse toDto(Employee employee) {
        return modelMapper.map(employee, EmployeeResponse.class);
    }

    public Employee toEntity(CreateEmployeeDto createEmployeeDto) {
        return modelMapper.map(createEmployeeDto, Employee.class);
    }

    public void toEntity(Employee employee, EmployeeRequest employeeRequest) {
        modelMapper.map(employeeRequest, employee);
    }
}
