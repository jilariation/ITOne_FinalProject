package com.github.itonefinalproject.services.cards.backend.implementation.controller;

import com.github.itonefinalproject.services.cards.backend.controller.AbstractController;
import com.github.itonefinalproject.services.cards.backend.implementation.service.CardService;
import com.github.itonefinalproject.services.cards.backend.mapper.CardModelMapper;
import com.github.itonefinalproject.services.cards.domain.Card;
import com.github.itonefinalproject.services.cards.dto.CardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/card")
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
