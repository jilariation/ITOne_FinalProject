package com.github.itonefinalproject.backend.implementation.service;

import com.github.itonefinalproject.backend.implementation.repository.DeskRepository;
import com.github.itonefinalproject.domain.Desk;
import com.github.itonefinalproject.backend.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Сервис для {@link Desk}
 */
@Service
@RequiredArgsConstructor
public class DeskService extends AbstractService<Desk> {
    private final DeskRepository deskRepository;
    @Override
    @Transactional
    public void createEntity(Desk entity) {
        deskRepository.save(entity);
    }

    @Override
    @Transactional
    public Desk findById(UUID id) {
        return deskRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public void updateEntity(UUID id, Desk updatedEntity) {
        Desk desk = deskRepository.findById(id).orElseThrow();
        desk.setName(updatedEntity.getName());
        desk.setCards(updatedEntity.getCards());
        desk.setEmployees(updatedEntity.getEmployees());
        desk.setUpdated(LocalDateTime.now());
        deskRepository.save(desk);
    }

    @Override
    @Transactional
    public void deleteEntity(UUID id) {
        deskRepository.deleteById(id);
    }

    @Transactional
    public List<Desk> findAll() {
        return deskRepository.findAll();
    }
}
