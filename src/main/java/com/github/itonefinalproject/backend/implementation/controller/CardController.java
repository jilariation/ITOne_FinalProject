package com.github.itonefinalproject.backend.implementation.controller;

import com.github.itonefinalproject.backend.mapper.TaskModelMapper;
import com.github.itonefinalproject.domain.Card;
import com.github.itonefinalproject.backend.controller.AbstractController;
import com.github.itonefinalproject.backend.implementation.service.CardService;
import com.github.itonefinalproject.backend.mapper.CardModelMapper;
import com.github.itonefinalproject.dto.CardDtoForCardController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Rest контроллер для взаимодействия с {@link Card}
 */
@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController extends AbstractController<CardDtoForCardController> {
    private final CardService cardService;
    private final CardModelMapper cardModelMapper;
    private final TaskModelMapper taskModelMapper;

    @GetMapping()
    public List<CardDtoForCardController> findAllCards() {
        return cardService.findAll()
                .stream()
                .map(card -> new CardDtoForCardController(
                        card.getName(),
                        card.getDesk().getId(),
                        card.getTasks().stream().map(taskModelMapper::toDto).collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    @PostMapping("/create")
    @Override
    public ResponseEntity<HttpStatus> createEntity(@RequestBody CardDtoForCardController entityDTO) {
        Card card = cardModelMapper.toEntity(entityDTO);
        cardService.addCard(entityDTO.getDeskId(),card);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    @Override
    public ResponseEntity<CardDtoForCardController> findById(@PathVariable UUID id) {
        Card card = cardService.findById(id);
        CardDtoForCardController cardDto = cardModelMapper.toDto(card);
        return ResponseEntity.ok(cardDto);
    }

    @PostMapping("/update{id}")
    @Override
    public ResponseEntity<HttpStatus> updateEntity(@PathVariable UUID id,
                                                   @RequestBody CardDtoForCardController updatedEntity) {
        Card updatedCard = cardModelMapper.toEntity(updatedEntity);
        cardService.updateEntity(id, updatedCard);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete{id}")
    @Override
    public ResponseEntity<HttpStatus> deleteEntity(@PathVariable UUID id) {
        cardService.deleteEntity(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
