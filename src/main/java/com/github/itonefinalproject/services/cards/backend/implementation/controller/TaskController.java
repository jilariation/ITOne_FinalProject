package com.github.itonefinalproject.services.cards.backend.implementation.controller;

import com.github.itonefinalproject.services.cards.backend.controller.AbstractController;
import com.github.itonefinalproject.services.cards.backend.implementation.service.TaskService;
import com.github.itonefinalproject.services.cards.backend.mapper.TaskModelMapper;
import com.github.itonefinalproject.services.cards.domain.Task;
import com.github.itonefinalproject.services.cards.dto.TaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController extends AbstractController<TaskDto> {
    private final TaskService taskService;
    private final TaskModelMapper taskModelMapper;
    @PostMapping("/create")
    @Override
    public ResponseEntity<HttpStatus> createEntity(@RequestBody TaskDto entityDTO) {
        Task task = taskModelMapper.toEntity(entityDTO);
        taskService.createEntity(task);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/find{id}")
    @Override
    public ResponseEntity<TaskDto> findById(@PathVariable int id) {
        Task task = taskService.findById(id);
        TaskDto  taskDto = taskModelMapper.toDto(task);
        return ResponseEntity.ok(taskDto);
    }

    @PostMapping("/update{id}")
    @Override
    public ResponseEntity<HttpStatus> updateEntity(@PathVariable int id, @RequestBody TaskDto updatedEntity) {
        Task task = taskModelMapper.toEntity(updatedEntity);
        taskService.updateEntity(id, task);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<HttpStatus> deleteEntity(@PathVariable int id) {
        taskService.deleteEntity(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
