package com.github.itonefinalproject.backend.implementation.controller;

import com.github.itonefinalproject.domain.Employee;
import com.github.itonefinalproject.dto.EmployeeDtoForDeskController;
import com.github.itonefinalproject.backend.controller.AbstractController;
import com.github.itonefinalproject.backend.implementation.service.EmployeeService;
import com.github.itonefinalproject.backend.mapper.EmployeeModelMapper;
import com.github.itonefinalproject.dto.EmployeeDtoForEmployeeController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Rest контроллер для взаимодействия с {@link Employee}
 */
@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController extends AbstractController<EmployeeDtoForEmployeeController> {
    private final EmployeeService employeeService;
    private final EmployeeModelMapper employeeModelMapper;

    @GetMapping
    public List<EmployeeDtoForEmployeeController> findAll() {
        return employeeService.findAll()
                .stream()
                .map(employee -> new EmployeeDtoForEmployeeController(
                        employee.getName(),
                        employee.getEmail(),
                        employee.getPassword(),
                        employee.getDesk().getId()
                )).collect(Collectors.toList());
    }

    @PostMapping("/create")
    @Override
    public ResponseEntity<HttpStatus> createEntity(@RequestBody EmployeeDtoForEmployeeController entityDTO) {
        Employee employee = employeeModelMapper.toEntity(entityDTO);
        employeeService.addEmployee(entityDTO.getDeskId(), employee);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    @Override
    public ResponseEntity<EmployeeDtoForEmployeeController> findById(@PathVariable UUID id) {
        Employee employee = employeeService.findById(id);
        EmployeeDtoForEmployeeController employeeDtoForDeskController = employeeModelMapper.toEmployeeDto(employee);
        return ResponseEntity.ok(employeeDtoForDeskController);
    }

    @PostMapping("/update/{id}")
    @Override
    public ResponseEntity<HttpStatus> updateEntity(@PathVariable UUID id, @RequestBody EmployeeDtoForEmployeeController updatedEntity) {
        Employee employee = employeeModelMapper.toEntity(updatedEntity);
        employeeService.updateEmployee(id, updatedEntity.getDeskId(), employee);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<HttpStatus> deleteEntity(@PathVariable UUID id) {
        employeeService.deleteEntity(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
