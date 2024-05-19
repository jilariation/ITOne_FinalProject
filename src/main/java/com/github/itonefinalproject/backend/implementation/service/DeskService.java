package com.github.itonefinalproject.backend.implementation.service;

import com.github.itonefinalproject.backend.implementation.repository.DeskRepository;
import com.github.itonefinalproject.domain.Desk;
import com.github.itonefinalproject.backend.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public List<Desk> findAll() {
        return deskRepository.findAll();
    }
}
