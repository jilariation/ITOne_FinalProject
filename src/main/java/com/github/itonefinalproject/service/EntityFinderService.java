package com.github.itonefinalproject.service;

import com.github.itonefinalproject.domain.Card;
import com.github.itonefinalproject.domain.Employee;

import com.github.itonefinalproject.dto.desk.CreateDeskDto;
import com.github.itonefinalproject.dto.desk.DeskRequest;
import com.github.itonefinalproject.dto.employee.EmployeeResponse;

import java.util.List;
import java.util.UUID;

public interface EntityFinderService {
    List<Card> getCards(List<UUID> uuids);
    List<Employee> getEmployees(List<UUID> uuids);
}