package com.github.itonefinalproject.services.cards.backend.implementation.service;

import com.github.itonefinalproject.services.cards.backend.implementation.repository.DeskRepository;
import com.github.itonefinalproject.services.cards.backend.service.AbstractService;
import com.github.itonefinalproject.services.cards.domain.Desk;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Сервис для {@link Desk}
 */
@Service
@RequiredArgsConstructor
public class DeskService extends AbstractService<Desk> {
    private final DeskRepository deskRepository;
    @Override
    public void createEntity(Desk entity) {
        deskRepository.createEntity(entity);
    }

    @Override
    public Desk findById(Integer id) {
        return deskRepository.findById(id);
    }

    @Override
    public void updateEntity(Integer id, Desk updatedEntity) {
        deskRepository.updateEntity(id, updatedEntity);
    }

    @Override
    public void deleteEntity(Integer id) {
        deskRepository.deleteEntity(id);
    }
}
