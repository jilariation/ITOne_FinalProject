package com.github.itonefinalproject.services.cards.backend.implementation.service;

import com.github.itonefinalproject.services.cards.backend.implementation.repository.CardRepository;
import com.github.itonefinalproject.services.cards.backend.service.AbstractService;
import com.github.itonefinalproject.services.cards.domain.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Сервис для {@link Card}
 */
@Service
@RequiredArgsConstructor
public class CardService extends AbstractService<Card> {
    private final CardRepository cardRepository;

    @Override
    public void createEntity(Card entity) {
        cardRepository.createEntity(entity);
    }

    @Override
    public Card findById(Integer id) {
        return cardRepository.findById(id);
    }

    @Override
    public void updateEntity(Integer id, Card updatedEntity) {
        cardRepository.updateEntity(id, updatedEntity);
    }

    @Override
    public void deleteEntity(Integer id) {
        cardRepository.deleteEntity(id);
    }
}
