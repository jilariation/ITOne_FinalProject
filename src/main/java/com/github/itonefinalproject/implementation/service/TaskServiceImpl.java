package com.github.itonefinalproject.implementation.service;

import com.github.itonefinalproject.dto.task.CreateTaskDto;
import com.github.itonefinalproject.dto.task.TaskRequest;
import com.github.itonefinalproject.dto.task.TaskResponse;
import com.github.itonefinalproject.repository.TaskRepository;
import com.github.itonefinalproject.domain.Task;
import com.github.itonefinalproject.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Сервис для {@link Task}
 */
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    public TaskResponse createEntity(CreateTaskDto entityDto) {
        return null;
    }

    @Override
    public TaskResponse findById(UUID id) {
        return null;
    }

    @Override
    public TaskResponse updateEntity(UUID id, TaskRequest updatedEntityDto) {
        return null;
    }

    @Override
    public void deleteEntity(UUID id) {

    }

    @Override
    public List<TaskResponse> findAll() {
        return null;
    }
//    @Override
//    @Transactional
//    public void createEntity(Task entity) {
//        taskRepository.save(entity);
//    }
//
//    @Override
//    @Transactional
//    public Task findById(UUID id) {
//        return taskRepository.findById(id).orElseThrow();
//    }
//
//    @Override
//    @Transactional
//    public void updateEntity(UUID id, Task updatedEntity) {
//        updatedEntity.setId(id);
//        taskRepository.save(updatedEntity);
//    }
//
//    @Override
//    @Transactional
//    public void deleteEntity(UUID id) {
//        taskRepository.deleteById(id);
//    }
//
//    @Transactional
//    public List<Task> findAll() {
//        return taskRepository.findAll();
//    }
//
//    @Transactional
//    public void addTask(UUID cardId, UUID employeeId, Task task) {
//        enrichTask(task, cardId, employeeId);
//        taskRepository.save(task);
//    }
//
//    @Transactional
//    public void updateTask(UUID taskId, UUID cardId, UUID employeeId, Task updatedEntity) {
//        Task task = taskRepository.findById(taskId).orElseThrow();
//        task.setKindOfTaskEnum(updatedEntity.getKindOfTaskEnum());
//        task.setName(updatedEntity.getName());
//        task.setUpdated(LocalDateTime.now());
//        addTask(cardId, employeeId, task);
//    }
//
//    private void enrichTask(Task task, UUID cardId, UUID employeeId) {
//        task.setCard(cardService.findById(cardId));
//        task.setEmployee(employeeService.findById(employeeId));
//    }
}