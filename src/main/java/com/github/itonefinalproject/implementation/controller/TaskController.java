package com.github.itonefinalproject.implementation.controller;

import com.github.itonefinalproject.dto.task.CreateTaskDto;
import com.github.itonefinalproject.dto.task.TaskRequest;
import com.github.itonefinalproject.dto.task.TaskResponse;
import com.github.itonefinalproject.implementation.service.TaskServiceImpl;
import com.github.itonefinalproject.controller.AbstractController;
import com.github.itonefinalproject.domain.Task;
import com.github.itonefinalproject.mapper.TaskModelMapper;
import com.github.itonefinalproject.service.TaskService;
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
 * Rest контроллер для взаимодействия с {@link Task}
 */
@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
@Tag(name = "Tasks", description = "Контроллер для работы с задачами")
public class TaskController
        extends AbstractController<TaskRequest, TaskResponse, CreateTaskDto> {

    private final TaskService taskService;

    @Operation(summary = "Получает все задачи")
    @GetMapping
    @Override
    public ResponseEntity<List<TaskResponse>> findAll() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @Operation(summary = "Добавить доску")
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public ResponseEntity<TaskResponse> createEntity(@RequestBody @Valid CreateTaskDto entityDTO) {
        return new ResponseEntity<>(taskService.createEntity(entityDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "Получить задачу по ее id")
    @GetMapping("/find/{id}")
    @Override
    public ResponseEntity<TaskResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(taskService.findById(id));
    }

    @Operation(summary = "Обновить задачу по ее id")
    @PostMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public ResponseEntity<HttpStatus> updateEntity(@PathVariable UUID id, @RequestBody @Valid TaskRequest updatedEntityDto) {
        return ResponseEntity.ok(taskService.updateEntity(id, updatedEntityDto));
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<HttpStatus> deleteEntity(@PathVariable UUID id) {
        taskService.deleteEntity(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
