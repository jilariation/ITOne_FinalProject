package com.github.itonefinalproject.mapper;

import com.github.itonefinalproject.domain.Card;
import com.github.itonefinalproject.dto.card.CardRequest;
import com.github.itonefinalproject.dto.card.CardResponse;
import com.github.itonefinalproject.dto.task.TaskResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CardModelMapper extends AbstractModelMapper<Card, CardRequest, CardResponse>{
    private final ModelMapper modelMapper;
    private final TaskModelMapper taskModelMapper;


    @Override
    public Card toEntity(CardResponse dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Card.class);
    }

    @Override
    public CardResponse toDto(Card card) {
        CardResponse cardResponse = Objects.isNull(card) ? null : modelMapper.map(card, CardResponse.class);

        List<TaskResponse> taskResponseList = card.getTasks().stream()
                .map(taskModelMapper::toDto)
                .collect(Collectors.toList());

        cardResponse.setTasks(taskResponseList);

        return cardResponse;
    }

    public Card toEntity()
}
