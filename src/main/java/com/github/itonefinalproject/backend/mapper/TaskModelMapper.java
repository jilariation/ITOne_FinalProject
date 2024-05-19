package com.github.itonefinalproject.backend.mapper;

import com.github.itonefinalproject.domain.Task;
import com.github.itonefinalproject.dto.TaskDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class TaskModelMapper extends AbstractModelMapper<Task, TaskDto> {
    private final ModelMapper modelMapper;

    @Override
    public Task toEntity(TaskDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Task.class);
    }

    @Override
    public TaskDto toDto(Task entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, TaskDto.class);
    }
}
