package com.github.itonefinalproject.services.cards.backend.implementation.controller;

import com.github.itonefinalproject.services.cards.backend.controller.AbstractController;
import com.github.itonefinalproject.services.cards.backend.implementation.service.CardService;
import com.github.itonefinalproject.services.cards.dto.CardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController extends AbstractController<CardDto> {
    private final CardService cardService;
    @Override
    public ResponseEntity<HttpStatus> createEntity(CardDto entityDTO) {
        return null;
    }

    @Override
    public ResponseEntity<HttpStatus> findById(int id) {
        return null;
    }

    @Override
    public ResponseEntity<HttpStatus> updateEntity(int id, CardDto updatedEntity) {
        return null;
    }

    @Override
    public ResponseEntity<HttpStatus> deleteEntity(int id) {
        return null;
    }
}
