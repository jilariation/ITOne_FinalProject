package com.github.itonefinalproject.implementation.service;

import com.github.itonefinalproject.domain.Card;
import com.github.itonefinalproject.domain.Employee;
import com.github.itonefinalproject.dto.desk.CreateDeskDto;
import com.github.itonefinalproject.dto.desk.DeskRequest;
import com.github.itonefinalproject.repository.CardRepository;
import com.github.itonefinalproject.repository.EmployeeRepository;
import com.github.itonefinalproject.service.EntityFinderService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EntityFinderServiceImpl implements EntityFinderService {
    private final CardRepository cardRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public List<Card> getCards(List<UUID> uuids) {
        if (uuids == null) return new ArrayList<>();
        else {
            return cardRepository.findAllById(uuids);
        }
    }

    @Override
    public List<Employee> getEmployees(List<UUID> uuids) {
        if(uuids == null) return new ArrayList<>();
        else {
            return employeeRepository.findAllById(uuids);
        }
    }
}
