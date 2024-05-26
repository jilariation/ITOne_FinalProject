package com.github.itonefinalproject.mapper;

import com.github.itonefinalproject.domain.Employee;
import com.github.itonefinalproject.domain.Task;
import com.github.itonefinalproject.dto.employee.EmployeeResponse;
import com.github.itonefinalproject.dto.task.CreateTaskDto;
import com.github.itonefinalproject.dto.task.TaskRequest;
import com.github.itonefinalproject.dto.task.TaskResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TaskModelMapper extends AbstractModelMapper<Task, TaskResponse> {
    private final ModelMapper modelMapper;
    private final EmployeeModelMapper employeeModelMapper;

    @Override
    public Task toEntity(TaskResponse dto) {
        return null;
    }

    @Override
    public TaskResponse toDto(Task task) {
        TaskResponse taskResponse = modelMapper.map(task, TaskResponse.class);
        List<EmployeeResponse> employeeResponseList = task.getEmployees().stream()
                .map(employeeModelMapper::toDto)
                .toList();
        taskResponse.setEmployees(employeeResponseList);
        return taskResponse;
    }

    public Task toEntity(CreateTaskDto createTaskDto) {
        Task task = new Task();
        task.setName(createTaskDto.getName());
        task.setKindOfTask(createTaskDto.getKindOfTask());
        return task;
    }

    public void toEntity(Task task, TaskRequest taskRequest) {
        task.setName(taskRequest.getName());
        task.setKindOfTask(taskRequest.getKindOfTask());
    }

//    @Override
//    public Task toEntity(TaskResponse dto) {
//        return null;
//    }
//
//    @Override
//    public TaskResponse toDto(Task task) {
//        TaskResponse taskResponse = Objects.isNull(task) ? null : modelMapper.map(task, TaskResponse.class);
//
//        List<EmployeeResponse> employeeResponseList = task.getEmployees().stream()
//                .map(employeeModelMapper::toDto)
//                .toList();
//
//        taskResponse.setEmployees(employeeResponseList);
//
//        return taskResponse;
//    }
}
