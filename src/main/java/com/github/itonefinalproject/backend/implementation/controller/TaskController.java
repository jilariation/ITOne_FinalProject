package com.github.itonefinalproject.backend.implementation.controller;

import com.github.itonefinalproject.backend.implementation.service.TaskService;
import com.github.itonefinalproject.domain.Task;
import com.github.itonefinalproject.backend.controller.AbstractController;
import com.github.itonefinalproject.backend.mapper.TaskModelMapper;
import com.github.itonefinalproject.dto.TaskDtoForTaskController;
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
public class TaskController extends AbstractController<TaskDtoForTaskController> {
    private final TaskService taskService;
    private final TaskModelMapper taskModelMapper;

    @GetMapping
    public List<TaskDtoForTaskController> findAll() {
        return taskService.findAll()
                .stream()
                .map(taskModelMapper::toTaskDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/create")
    @Override
    public ResponseEntity<HttpStatus> createEntity(@RequestBody TaskDtoForTaskController entityDTO) {
        Task task = taskModelMapper.toEntity(entityDTO);
        taskService.addTask(entityDTO.getCardId(), entityDTO.getEmployeeId(), task);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    @Override
    public ResponseEntity<TaskDtoForTaskController> findById(@PathVariable UUID id) {
        Task task = taskService.findById(id);
        TaskDtoForTaskController taskDto = taskModelMapper.toTaskDto(task);
        return ResponseEntity.ok(taskDto);
    }

    @PostMapping("/update/{id}")
    @Override
    public ResponseEntity<HttpStatus> updateEntity(@PathVariable UUID id, @RequestBody TaskDtoForTaskController updatedEntity) {
        Task task = taskModelMapper.toEntity(updatedEntity);
        taskService.updateTask(id, updatedEntity.getCardId(), updatedEntity.getEmployeeId(), task);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<HttpStatus> deleteEntity(@PathVariable UUID id) {
        taskService.deleteEntity(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
