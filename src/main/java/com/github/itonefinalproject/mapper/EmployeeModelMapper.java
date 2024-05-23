package com.github.itonefinalproject.mapper;

import com.github.itonefinalproject.domain.Employee;
import com.github.itonefinalproject.dto.employee.EmployeeRequest;
import com.github.itonefinalproject.dto.employee.EmployeeResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class EmployeeModelMapper extends AbstractModelMapper<Employee, EmployeeRequest, EmployeeResponse> {
    private final ModelMapper modelMapper;

    @Override
    public Employee toEntity(EmployeeResponse dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Employee.class);
    }

    @Override
    public EmployeeResponse toDto(Employee employee) {
        return Objects.isNull(employee) ? null : modelMapper.map(employee, EmployeeResponse.class);
    }
}
