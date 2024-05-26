package com.github.itonefinalproject.service;

import com.github.itonefinalproject.domain.Employee;
import com.github.itonefinalproject.dto.employee.CreateEmployeeDto;
import com.github.itonefinalproject.dto.employee.EmployeeRequest;
import com.github.itonefinalproject.dto.employee.EmployeeResponse;

import java.util.List;
import java.util.UUID;

public interface EmployeeService extends AbstractService<EmployeeRequest, EmployeeResponse, CreateEmployeeDto> {
}
