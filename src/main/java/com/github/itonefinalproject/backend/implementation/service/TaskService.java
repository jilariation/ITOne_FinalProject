package com.github.itonefinalproject.backend.implementation.service;

import com.github.itonefinalproject.backend.implementation.repository.TaskRepository;
import com.github.itonefinalproject.domain.Card;
import com.github.itonefinalproject.domain.Employee;
import com.github.itonefinalproject.domain.Task;
import com.github.itonefinalproject.backend.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Сервис для {@link Task}
 */
@Service
@RequiredArgsConstructor
public class TaskService extends AbstractService<Task> {
    private final TaskRepository taskRepository;
    private final CardService cardService;
    private final EmployeeService employeeService;
    @Override
    @Transactional
    public void createEntity(Task entity) {
        taskRepository.save(entity);
    }

    @Override
    @Transactional
    public Task findById(UUID id) {
        return taskRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public void updateEntity(UUID id, Task updatedEntity) {
        updatedEntity.setId(id);
        taskRepository.save(updatedEntity);
    }

    @Override
    @Transactional
    public void deleteEntity(UUID id) {
        taskRepository.deleteById(id);
    }

    @Transactional
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Transactional
    public void addTask(UUID cardId, UUID employeeId, Task task) {
        enrichTask(task, cardId, employeeId);
        taskRepository.save(task);
    }

    @Transactional
    public void updateTask(UUID taskId, UUID cardId, UUID employeeId, Task updatedEntity) {
        Task task = taskRepository.findById(taskId).orElseThrow();
        task.setKindOfTaskEnum(updatedEntity.getKindOfTaskEnum());
        task.setName(updatedEntity.getName());
        task.setUpdated(LocalDateTime.now());
        addTask(cardId, employeeId, task);
    }

    private void enrichTask(Task task, UUID cardId, UUID employeeId) {
        task.setCard(cardService.findById(cardId));
        task.setEmployee(employeeService.findById(employeeId));
    }
}