package com.github.itonefinalproject.backend.implementation.service;

import com.github.itonefinalproject.backend.implementation.repository.TaskRepository;
import com.github.itonefinalproject.domain.Task;
import com.github.itonefinalproject.backend.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Сервис для {@link Task}
 */
@Service
@RequiredArgsConstructor
public class TaskService extends AbstractService<Task> {
    private final TaskRepository taskRepository;
    @Override
    public void createEntity(Task entity) {
        taskRepository.save(entity);
    }

    @Override
    public Task findById(UUID id) {
        return taskRepository.findById(id).orElseThrow();
    }

    @Override
    public void updateEntity(UUID id, Task updatedEntity) {
        updatedEntity.setId(id);
        taskRepository.save(updatedEntity);
    }

    @Override
    public void deleteEntity(UUID id) {
        taskRepository.deleteById(id);
    }
}