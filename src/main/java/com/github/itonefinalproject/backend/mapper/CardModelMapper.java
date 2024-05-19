package com.github.itonefinalproject.backend.mapper;

import com.github.itonefinalproject.domain.Card;
import com.github.itonefinalproject.dto.CardDto;
import com.github.itonefinalproject.dto.CardDtoForCardController;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CardModelMapper extends AbstractModelMapper<Card, CardDtoForCardController>{
    private final ModelMapper modelMapper;

    @Override
    public Card toEntity(CardDtoForCardController dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Card.class);
    }

    @Override
    public CardDtoForCardController toDto(Card entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, CardDtoForCardController.class);
    }

}
