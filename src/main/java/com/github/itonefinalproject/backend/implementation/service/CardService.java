package com.github.itonefinalproject.backend.implementation.service;

import com.github.itonefinalproject.backend.implementation.repository.CardRepository;
import com.github.itonefinalproject.domain.Card;
import com.github.itonefinalproject.backend.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Сервис для {@link Card}
 */
@Service
@RequiredArgsConstructor
public class CardService extends AbstractService<Card> {
    private final CardRepository cardRepository;
    private final DeskService deskService;

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

    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    public void addCard(UUID uuid, Card card) {
        enrichDesk(card, uuid);
        cardRepository.save(card);
    }

    private void enrichDesk(Card card,UUID uuid) {
        card.setDesk(deskService.findById(uuid));
    }
}