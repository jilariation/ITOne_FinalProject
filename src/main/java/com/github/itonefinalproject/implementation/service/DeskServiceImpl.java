package com.github.itonefinalproject.implementation.service;

import com.github.itonefinalproject.dto.desk.CreateDeskDto;
import com.github.itonefinalproject.dto.desk.DeskRequest;
import com.github.itonefinalproject.dto.desk.DeskResponse;
import com.github.itonefinalproject.repository.DeskRepository;
import com.github.itonefinalproject.domain.Desk;
import com.github.itonefinalproject.mapper.DeskModelMapper;
import com.github.itonefinalproject.service.DeskService;
import com.github.itonefinalproject.service.EntityFinderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    private final EntityFinderService entityFinderService;

    @Transactional
    @Override
    public DeskResponse createEntity(CreateDeskDto entityDto) {
        Desk desk = deskModelMapper.toEntity(entityDto);

        desk.setEmployees(entityFinderService.getEmployees(entityDto.getEmployeeUuidsList()));
        desk.setCards(entityFinderService.getCards(entityDto.getCardUuidsList()));

        deskRepository.save(desk);

        return deskModelMapper.toDto(desk);
    }

    @Override
    public DeskResponse findById(UUID id) {
        Desk desk = deskRepository.findById(id).orElseThrow();
        return deskModelMapper.toDto(desk);
    }

    @Override
    public DeskResponse updateEntity(UUID id, DeskRequest updatedEntityDto) {
        Desk desk = deskRepository.findById(id).orElseThrow();
        deskModelMapper.toEntity(desk, updatedEntityDto);
        deskRepository.save(desk);
        return deskModelMapper.toDto(desk);
    }

    @Override
    public void deleteEntity(UUID id) {
        deskRepository.deleteById(id);
    }

    @Override
    public List<DeskResponse> findAll() {
        return deskRepository.findAll().stream()
                .map(deskModelMapper::toDto)
                .collect(Collectors.toList());
    }
}
