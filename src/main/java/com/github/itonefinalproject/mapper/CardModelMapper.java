package com.github.itonefinalproject.mapper;

import com.github.itonefinalproject.domain.Card;
import com.github.itonefinalproject.dto.card.CardRequest;
import com.github.itonefinalproject.dto.card.CardResponse;
import com.github.itonefinalproject.dto.card.CreateCardDto;
import com.github.itonefinalproject.dto.task.TaskResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CardModelMapper extends AbstractModelMapper<Card, CardResponse>{
    private final ModelMapper modelMapper;
    private final TaskModelMapper taskModelMapper;

    @Override
    public Card toEntity(CardResponse dto) {
        return null;
    }

    @Override
    public CardResponse toDto(Card card) {
        CardResponse cardResponse = modelMapper.map(card, CardResponse.class);

        List<TaskResponse> taskResponseList = card.getTasks().stream()
                .map(taskModelMapper::toDto)
                .toList();
        cardResponse.setTasks(taskResponseList);
        return cardResponse;
    }

    public Card toEntity(CreateCardDto createCardDto) {
        Card card = new Card();
        card.setName(createCardDto.getName());
        return card;
    }

    public void toEntity(Card card, CardRequest cardRequest) {
        modelMapper.map(cardRequest, card);
    }


//    @Override
//    public Card toEntity(CardResponse dto) {
//        return Objects.isNull(dto) ? null : modelMapper.map(dto, Card.class);
//    }
//
//    @Override
//    public CardResponse toDto(Card card) {
//        CardResponse cardResponse = Objects.isNull(card) ? null : modelMapper.map(card, CardResponse.class);
//
//        List<TaskResponse> taskResponseList = card.getTasks().stream()
//                .map(taskModelMapper::toDto)
//                .collect(Collectors.toList());
//
//        cardResponse.setTasks(taskResponseList);
//
//        return cardResponse;
//    }
//
//    public Card toEntity()
}
