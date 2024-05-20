package com.github.itonefinalproject.backend.mapper;

import com.github.itonefinalproject.domain.Card;
import com.github.itonefinalproject.dto.CardDtoForCardController;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CardModelMapper extends AbstractModelMapper<Card, CardDtoForCardController>{
    private final ModelMapper modelMapper;
    private final TaskModelMapper taskModelMapper;

    @Override
    public Card toEntity(CardDtoForCardController dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Card.class);
    }

    @Override
    public CardDtoForCardController toDto(Card entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, CardDtoForCardController.class);
    }

    public CardDtoForCardController toCardDto(Card entity) {
        return new CardDtoForCardController(
                entity.getName(),
                entity.getDesk().getId(),
                entity.getTasks().stream().map(taskModelMapper::toDto).collect(Collectors.toList())
        );
    }
}
