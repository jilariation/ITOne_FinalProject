package com.github.itonefinalproject.implementation.controller;

import com.github.itonefinalproject.controller.AbstractController;
import com.github.itonefinalproject.domain.Employee;
import com.github.itonefinalproject.dto.employee.CreateEmployeeDto;
import com.github.itonefinalproject.dto.employee.EmployeeRequest;
import com.github.itonefinalproject.dto.employee.EmployeeResponse;
import com.github.itonefinalproject.implementation.service.EmployeeServiceImpl;
import com.github.itonefinalproject.mapper.EmployeeModelMapper;
import com.github.itonefinalproject.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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
@Tag(name = "Employee", description = "Контроллер для работы с сотрудниками")
public class EmployeeController
        extends AbstractController<EmployeeRequest, EmployeeResponse, CreateEmployeeDto> {

    private final EmployeeService employeeService;

    @Operation(summary = "Получает всех сотрудников")
    @GetMapping
    @Override
    public ResponseEntity<List<EmployeeResponse>> findAll() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @Operation(summary = "Добавить сотрудника")
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public ResponseEntity<EmployeeResponse> createEntity(@RequestBody @Valid CreateEmployeeDto entityDTO) {
       return new ResponseEntity<>(employeeService.createEntity(entityDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "Получить доску по ее id")
    @GetMapping("/find/{id}")
    @Override
    public ResponseEntity<EmployeeResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @Operation(summary = "Обновляет карточку по ее id")
    @PostMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public ResponseEntity<HttpStatus> updateEntity(@PathVariable UUID id, @RequestBody @Valid EmployeeRequest updatedEntityDto) {
        return ResponseEntity.ok(employeeService.updateEntity(id,updatedEntityDto));
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<HttpStatus> deleteEntity(@PathVariable UUID id) {
        employeeServiceImpl.deleteEntity(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
