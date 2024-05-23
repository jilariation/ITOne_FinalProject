package com.github.itonefinalproject.implementation.service;

import com.github.itonefinalproject.domain.Card;
import com.github.itonefinalproject.domain.Employee;
import com.github.itonefinalproject.dto.desk.CreateDeskDto;
import com.github.itonefinalproject.dto.desk.DeskRequest;
import com.github.itonefinalproject.dto.desk.DeskResponse;
import com.github.itonefinalproject.implementation.repository.DeskRepository;
import com.github.itonefinalproject.domain.Desk;
import com.github.itonefinalproject.mapper.CardModelMapper;
import com.github.itonefinalproject.mapper.DeskModelMapper;
import com.github.itonefinalproject.mapper.EmployeeModelMapper;
import com.github.itonefinalproject.service.AbstractService;
import com.github.itonefinalproject.service.CardService;
import com.github.itonefinalproject.service.DeskService;
import com.github.itonefinalproject.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Сервис для {@link Desk}
 */
@Service
@RequiredArgsConstructor
public class DeskServiceImpl implements DeskService {
    private final DeskModelMapper deskModelMapper;
    private final DeskRepository deskRepository;

    private final CardService cardService;
    private final CardModelMapper cardModelMapper;

    private final EmployeeService employeeService;
    private final EmployeeModelMapper employeeModelMapper;
    @Override
    @Transactional
    public DeskResponse createEntity(CreateDeskDto entityDto) {
        Desk newDesk = deskModelMapper.toEntity(entityDto);
        enrichDesk(newDesk, entityDto);
        deskRepository.save(newDesk);
        return deskModelMapper.toDto(newDesk);
    }

    @Override
    @Transactional
    public DeskResponse findById(UUID id) {
        Desk desk = deskRepository.findById(id).orElseThrow();
        return deskModelMapper.toDto(desk);
    }

    @Override
    @Transactional
    public void updateEntity(UUID id, DeskRequest updatedEntityDto) {
        Desk desk = deskRepository.findById(id).orElseThrow();
        deskModelMapper.toEntity(desk, updatedEntityDto);
        deskRepository.save(desk);
    }

    @Override
    @Transactional
    public void deleteEntity(UUID id) {
        deskRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<DeskResponse> findAll() {
        return deskRepository.findAll().stream()
                .map(deskModelMapper::toDto)
                .collect(Collectors.toList());
    }

    private void enrichDesk(Desk desk, CreateDeskDto createDeskDto) {
        desk.setEmployees(getEmployees(createDeskDto));
        desk.setCards(getCards(createDeskDto));
    }

    private List<Card> getCards(CreateDeskDto createDeskDto) {
        if (createDeskDto.getCardsId() == null) return new ArrayList<>();
        else {
            return cardService.getCardsById(createDeskDto.getCardsId()).stream()
                    .map(cardModelMapper::toEntity)
                    .collect(Collectors.toList());
        }
    }

    private List<Employee> getEmployees(CreateDeskDto createDeskDto) {
        if(createDeskDto.getEmployeeIds() == null) return new ArrayList<>();
        else {
            return employeeService.getEmployeesById(createDeskDto.getEmployeeIds()).stream()
                    .map(employeeModelMapper::toEntity)
                    .collect(Collectors.toList());
        }
    }
}
