package com.github.itonefinalproject.services.cards.backend.implementation.service;

import com.github.itonefinalproject.services.cards.backend.implementation.repository.DeskRepository;
import com.github.itonefinalproject.services.cards.backend.service.AbstractService;
import com.github.itonefinalproject.services.cards.domain.Desk;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Сервис для {@link Desk}
 */
@Service
@RequiredArgsConstructor
public class DeskService extends AbstractService<Desk> {
    private final DeskRepository deskRepository;
    @Override
    public void createEntity(Desk entity) {
        deskRepository.save(entity);
    }

    @Override
    public Desk findById(UUID id) {
        return deskRepository.findById(id).orElseThrow();
    }

    @Override
    public void updateEntity(UUID id, Desk updatedEntity) {
        updatedEntity.setId(id);
        deskRepository.save(updatedEntity);
    }

    @Override
    public void deleteEntity(UUID id) {
        deskRepository.deleteById(id);
    }
}
