package com.github.itonefinalproject.implementation.service;

import com.github.itonefinalproject.dto.task.CreateTaskDto;
import com.github.itonefinalproject.dto.task.TaskRequest;
import com.github.itonefinalproject.dto.task.TaskResponse;
import com.github.itonefinalproject.mapper.TaskModelMapper;
import com.github.itonefinalproject.repository.CardRepository;
import com.github.itonefinalproject.repository.TaskRepository;
import com.github.itonefinalproject.domain.Task;
import com.github.itonefinalproject.service.EntityFinderService;
import com.github.itonefinalproject.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Сервис для {@link Task}
 */
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskModelMapper taskModelMapper;

    private final CardRepository cardRepository;

    private final EntityFinderService entityFinderService;

    @Override
    public TaskResponse createEntity(CreateTaskDto entityDto) {
        Task task = taskModelMapper.toEntity(entityDto);
        task.setEmployees(entityFinderService.getEmployees(entityDto));
        task.setCard(cardRepository.findById(entityDto.getCardId()).orElseThrow());
        taskRepository.save(task);
        return taskModelMapper.toDto(task);
    }

    @Override
    public TaskResponse findById(UUID id) {
        return taskModelMapper.toDto(taskRepository.findById(id).orElseThrow());
    }

    @Override
    public TaskResponse updateEntity(UUID id, TaskRequest updatedEntityDto) {
        Task task = taskRepository.findById(id).orElseThrow();
        taskModelMapper.toEntity(task, updatedEntityDto);
        taskRepository.save(task);
        return taskModelMapper.toDto(task);
    }

    @Override
    public void deleteEntity(UUID id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<TaskResponse> findAll() {
        return taskRepository.findAll().stream()
                .map(taskModelMapper::toDto)
                .collect(Collectors.toList());
    }
}