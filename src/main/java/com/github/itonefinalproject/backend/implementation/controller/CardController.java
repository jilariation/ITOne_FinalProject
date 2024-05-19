package com.github.itonefinalproject.backend.implementation.controller;

import com.github.itonefinalproject.domain.Card;
import com.github.itonefinalproject.dto.CardDto;
import com.github.itonefinalproject.backend.controller.AbstractController;
import com.github.itonefinalproject.backend.implementation.service.CardService;
import com.github.itonefinalproject.backend.mapper.CardModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Rest контроллер для взаимодействия с {@link Card}
 */
@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController extends AbstractController<CardDto> {
    private final CardService cardService;
    private final CardModelMapper cardModelMapper;
    @PostMapping("/create")
    @Override
    public ResponseEntity<HttpStatus> createEntity(@RequestBody CardDto entityDTO) {
        Card card = cardModelMapper.toEntity(entityDTO);
        cardService.createEntity(card);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    @Override
    public ResponseEntity<CardDto> findById(@PathVariable UUID id) {
        Card card = cardService.findById(id);
        CardDto cardDto = cardModelMapper.toDto(card);
        return ResponseEntity.ok(cardDto);
    }

    @PostMapping("/update{id}")
    @Override
    public ResponseEntity<HttpStatus> updateEntity(@PathVariable UUID id,
                                                   @RequestBody CardDto updatedEntity) {
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
