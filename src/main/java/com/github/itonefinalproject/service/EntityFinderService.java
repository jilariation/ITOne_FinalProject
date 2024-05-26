package com.github.itonefinalproject.service;

import com.github.itonefinalproject.domain.Card;
import com.github.itonefinalproject.domain.Desk;
import com.github.itonefinalproject.domain.Employee;

import com.github.itonefinalproject.domain.Task;
import com.github.itonefinalproject.dto.desk.CreateDeskDto;
import com.github.itonefinalproject.dto.desk.DeskRequest;
import com.github.itonefinalproject.dto.employee.EmployeeResponse;
import com.github.itonefinalproject.dto.task.CreateTaskDto;

import java.util.List;
import java.util.UUID;

public interface EntityFinderService {
    List<Card> getCards(List<UUID> uuids);
    List<Employee> getEmployees(List<UUID> uuids);
    List<Task> getTasks(List<UUID> uuids);
    List<Employee> getEmployees(CreateTaskDto createTaskDto);
    Desk getDesk(UUID uuid);
}