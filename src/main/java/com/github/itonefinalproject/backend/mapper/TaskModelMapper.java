package com.github.itonefinalproject.backend.mapper;

import com.github.itonefinalproject.domain.Task;
import com.github.itonefinalproject.dto.TaskDtoForDeskController;
import com.github.itonefinalproject.dto.TaskDtoForTaskController;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class TaskModelMapper extends AbstractModelMapper<Task, TaskDtoForDeskController> {
    private final ModelMapper modelMapper;

    @Override
    public Task toEntity(TaskDtoForDeskController dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Task.class);
    }

    @Override
    public TaskDtoForDeskController toDto(Task entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, TaskDtoForDeskController.class);
    }

    public TaskDtoForTaskController toTaskDto(Task entity) {
        return new TaskDtoForTaskController(
                entity.getKindOfTaskEnum(),
                entity.getName(),
                entity.getCard().getId(),
                entity.getEmployee().getId()
        );
    }

    public Task toEntity(TaskDtoForTaskController taskDtoForTaskController){
        return Objects.isNull(taskDtoForTaskController) ? null : modelMapper.map(taskDtoForTaskController, Task.class);
    }
}
