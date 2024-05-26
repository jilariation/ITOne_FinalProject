package com.github.itonefinalproject.implementation.service;

import com.github.itonefinalproject.dto.card.CardRequest;
import com.github.itonefinalproject.dto.card.CardResponse;
import com.github.itonefinalproject.dto.card.CreateCardDto;
import com.github.itonefinalproject.mapper.CardModelMapper;
import com.github.itonefinalproject.repository.CardRepository;
import com.github.itonefinalproject.domain.Card;
import com.github.itonefinalproject.service.CardService;
import com.github.itonefinalproject.service.EntityFinderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Сервис для {@link Card}
 */
@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    private final CardModelMapper cardModelMapper;

    private final EntityFinderService entityFinderService;

    @Override
    public CardResponse createEntity(CreateCardDto entityDto) {
        Card card = cardModelMapper.toEntity(entityDto);

        card.setTasks(entityFinderService.getTasks(entityDto.getTasksIds()));
        card.setDesk(entityFinderService.getDesk(entityDto.getDeskId()));

        cardRepository.save(card);
        return cardModelMapper.toDto(card);
    }

    @Override
    public CardResponse findById(UUID id) {
        Card card = cardRepository.findById(id).orElseThrow();
        return cardModelMapper.toDto(card);
    }

    @Override
    public CardResponse updateEntity(UUID id, CardRequest updatedEntityDto) {
        Card card = cardRepository.findById(id).orElseThrow();
        cardModelMapper.toEntity(card, updatedEntityDto);
        cardRepository.save(card);
        return cardModelMapper.toDto(card);
    }

    @Override
    public void deleteEntity(UUID id) {
        cardRepository.deleteById(id);
    }

    @Override
    public List<CardResponse> findAll() {
        return cardRepository.findAll().stream()
                .map(cardModelMapper::toDto)
                .collect(Collectors.toList());
    }
}