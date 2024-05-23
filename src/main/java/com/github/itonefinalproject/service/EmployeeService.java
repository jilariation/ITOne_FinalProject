package com.github.itonefinalproject.service;

import com.github.itonefinalproject.domain.Employee;
import com.github.itonefinalproject.dto.employee.EmployeeRequest;
import com.github.itonefinalproject.dto.employee.EmployeeResponse;

import java.util.List;
import java.util.UUID;

public interface EmployeeService extends AbstractService<Employee, EmployeeResponse, EmployeeRequest> {
    /**
     * Находит dto всех {@link Employee} по их ID
     * @param uuid ID {@link Employee}
     * @return Возращает List со всеми {@link Employee}
     */
    List<EmployeeResponse> getEmployeesById(List<UUID> uuid);
}
