package com.github.itonefinalproject.backend.mapper;

import com.github.itonefinalproject.domain.Employee;
import com.github.itonefinalproject.dto.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class EmployeeModelMapper extends AbstractModelMapper<Employee, EmployeeDto> {
    private final ModelMapper modelMapper;
    @Override
    public Employee toEntity(EmployeeDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Employee.class);
    }

    @Override
    public EmployeeDto toDto(Employee entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, EmployeeDto.class);
    }
}
