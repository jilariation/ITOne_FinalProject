package com.github.itonefinalproject.services.cards.backend.implementation.service;

import com.github.itonefinalproject.services.cards.backend.implementation.repository.KindOfTaskRepository;
import com.github.itonefinalproject.services.cards.backend.service.AbstractService;
import com.github.itonefinalproject.services.cards.domain.KindOfTask;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Сервис для {@link KindOfTask}
 */
@Service
@RequiredArgsConstructor
public class KindOfTaskService extends AbstractService<KindOfTask> {
    private final KindOfTaskRepository kindOfTaskRepository;
    @Override
    public void createEntity(KindOfTask entity) {
        kindOfTaskRepository.createEntity(entity);
    }

    @Override
    public KindOfTask findById(Integer id) {
        return kindOfTaskRepository.findById(id);
    }

    @Override
    public void updateEntity(Integer id, KindOfTask updatedEntity) {
        kindOfTaskRepository.updateEntity(id, updatedEntity);
    }

    @Override
    public void deleteEntity(Integer id) {
        kindOfTaskRepository.deleteEntity(id);
    }
}
