package com.github.itonefinalproject.services.cards.backend.implementation.service;

import com.github.itonefinalproject.services.cards.backend.implementation.repository.TaskRepository;
import com.github.itonefinalproject.services.cards.backend.service.AbstractService;
import com.github.itonefinalproject.services.cards.domain.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Сервис для {@link Task}
 */
@Service
@RequiredArgsConstructor
public class TaskService extends AbstractService<Task> {
    private final TaskRepository taskRepository;
    @Override
    public void createEntity(Task entity) {
        taskRepository.createEntity(entity);
    }

    @Override
    public Task findById(Integer id) {
        return taskRepository.findById(id);
    }

    @Override
    public void updateEntity(Integer id, Task updatedEntity) {
        taskRepository.updateEntity(id, updatedEntity);
    }

    @Override
    public void deleteEntity(Integer id) {
        taskRepository.deleteEntity(id);
    }
}