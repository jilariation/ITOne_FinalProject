package com.github.itonefinalproject.services.cards.backend.implementation.service;

import com.github.itonefinalproject.services.cards.backend.implementation.repository.CardRepository;
import com.github.itonefinalproject.services.cards.backend.service.AbstractService;
import com.github.itonefinalproject.services.cards.domain.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Сервис для {@link Card}
 */
@Service
@RequiredArgsConstructor
public class CardService extends AbstractService<Card> {
    private final CardRepository cardRepository;

    @Override
    public void createEntity(Card entity) {
        cardRepository.save(entity);
    }

    @Override
    public Card findById(UUID id) {
        return cardRepository.findById(id).orElseThrow();
    }

    @Override
    public void updateEntity(UUID id, Card updatedEntity) {
        updatedEntity.setId(id);
        cardRepository.save(updatedEntity);
    }

    @Override
    public void deleteEntity(UUID id) {
        cardRepository.deleteById(id);
    }
}