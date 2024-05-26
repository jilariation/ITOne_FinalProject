package com.github.itonefinalproject.implementation.service;

import com.github.itonefinalproject.dto.card.CardRequest;
import com.github.itonefinalproject.dto.card.CardResponse;
import com.github.itonefinalproject.dto.card.CreateCardDto;
import com.github.itonefinalproject.repository.CardRepository;
import com.github.itonefinalproject.domain.Card;
import com.github.itonefinalproject.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Сервис для {@link Card}
 */
@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;

    @Override
    public CardResponse createEntity(CreateCardDto entityDto) {
        return null;
    }

    @Override
    public CardResponse findById(UUID id) {
        return null;
    }

    @Override
    public CardResponse updateEntity(UUID id, CardRequest updatedEntityDto) {
        return null;
    }

    @Override
    public void deleteEntity(UUID id) {

    }

    @Override
    public List<CardResponse> findAll() {
        return null;
    }

    @Override
    public List<CardResponse> getCardsById(List<UUID> uuid) {
        return null;
    }

//    @Transactional
//    @Override
//    public void createEntity(Card entity) {
//        cardRepository.save(entity);
//    }
//
//    @Override
//    @Transactional
//    public Card findById(UUID id) {
//        return cardRepository.findById(id).orElseThrow();
//    }
//
//    @Override
//    @Transactional
//    public void updateEntity(UUID id, Card updatedEntity) {
//        updatedEntity.setId(id);
//        addCard(id, updatedEntity);
//    }
//
//    @Override
//    @Transactional
//    public void deleteEntity(UUID id) {
//        cardRepository.deleteById(id);
//    }
//
//    @Transactional
//    public List<Card> findAll() {
//        return cardRepository.findAll();
//    }
//
//    @Transactional
//    public void addCard(UUID uuid, Card card) {
//        enrichDesk(card, uuid);
//        cardRepository.save(card);
//    }
//
//    @Transactional
//    public void updateCard(UUID cardId, UUID deskId, Card updatedEntity) {
//        Card card = cardRepository.findById(cardId).orElseThrow();
//        card.setName(updatedEntity.getName());
//        card.setTasks(updatedEntity.getTasks());
//        card.setUpdated(LocalDateTime.now());
//        addCard(deskId, card);
//    }
//
//    private void enrichDesk(Card card, UUID deskId) {
//        card.setDesk(deskService.findById(deskId));
//    }
}