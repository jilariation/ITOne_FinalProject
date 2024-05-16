package com.github.itonefinalproject.services.cards.backend.mapper;

import com.github.itonefinalproject.services.cards.domain.Card;
import com.github.itonefinalproject.services.cards.dto.CardDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CardModelMapper extends AbstractModelMapper<Card, CardDto>{
    private final ModelMapper modelMapper;

    @Override
    public Card toEntity(CardDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Card.class);
    }

    @Override
    public CardDto toDto(Card entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, CardDto.class);
    }
}
