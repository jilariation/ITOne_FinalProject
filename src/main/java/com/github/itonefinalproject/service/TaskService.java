package com.github.itonefinalproject.service;

import com.github.itonefinalproject.domain.Task;
import com.github.itonefinalproject.dto.task.CreateTaskDto;
import com.github.itonefinalproject.dto.task.TaskRequest;
import com.github.itonefinalproject.dto.task.TaskResponse;

public interface TaskService extends AbstractService<TaskRequest, TaskResponse, CreateTaskDto> {
}
