package com.github.itonefinalproject.backend.mapper;

import com.github.itonefinalproject.domain.Employee;
import com.github.itonefinalproject.dto.EmployeeDtoForDeskController;
import com.github.itonefinalproject.dto.EmployeeDtoForEmployeeController;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class EmployeeModelMapper extends AbstractModelMapper<Employee, EmployeeDtoForDeskController> {
    private final ModelMapper modelMapper;
    @Override
    public Employee toEntity(EmployeeDtoForDeskController dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Employee.class);
    }

    @Override
    public EmployeeDtoForDeskController toDto(Employee entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, EmployeeDtoForDeskController.class);
    }

    public EmployeeDtoForEmployeeController toEmployeeDto(Employee employee) {
        return new EmployeeDtoForEmployeeController(
                employee.getName(),
                employee.getEmail(),
                employee.getPassword(),
                employee.getDesk().getId()
        );
    }

    public Employee toEntity(EmployeeDtoForEmployeeController dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Employee.class);
    }
}
