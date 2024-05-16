package com.github.itonefinalproject.services.cards.backend.implementation.controller;

import com.github.itonefinalproject.services.cards.backend.controller.AbstractController;
import com.github.itonefinalproject.services.cards.backend.implementation.service.EmployeeService;
import com.github.itonefinalproject.services.cards.backend.mapper.EmployeeModelMapper;
import com.github.itonefinalproject.services.cards.domain.Employee;
import com.github.itonefinalproject.services.cards.dto.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController extends AbstractController<EmployeeDto> {
    private final EmployeeService employeeService;
    private final EmployeeModelMapper employeeModelMapper;

    @PostMapping("/create")
    @Override
    public ResponseEntity<HttpStatus> createEntity(@RequestBody EmployeeDto entityDTO) {
        Employee employee = employeeModelMapper.toEntity(entityDTO);
        employeeService.createEntity(employee);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    @Override
    public ResponseEntity<EmployeeDto> findById(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        EmployeeDto employeeDto = employeeModelMapper.toDto(employee);
        return ResponseEntity.ok(employeeDto);
    }

    @PostMapping("/update/{id}")
    @Override
    public ResponseEntity<HttpStatus> updateEntity(@PathVariable int id, @RequestBody EmployeeDto updatedEntity) {
        Employee employee = employeeModelMapper.toEntity(updatedEntity);
        employeeService.updateEntity(id, employee);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<HttpStatus> deleteEntity(@PathVariable int id) {
        employeeService.deleteEntity(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
