package com.github.itonefinalproject.implementation.controller;

import com.github.itonefinalproject.dto.card.CardRequest;
import com.github.itonefinalproject.dto.card.CardResponse;
import com.github.itonefinalproject.dto.card.CreateCardDto;
import com.github.itonefinalproject.mapper.TaskModelMapper;
import com.github.itonefinalproject.controller.AbstractController;
import com.github.itonefinalproject.domain.Card;
import com.github.itonefinalproject.implementation.service.CardServiceImpl;
import com.github.itonefinalproject.mapper.CardModelMapper;
import com.github.itonefinalproject.service.CardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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
@Tag(name = "Cards", description = "Контроллер для работы с карточками")
public class CardController
        extends AbstractController<CardRequest, CardResponse, CreateCardDto> {
    private final CardService cardService;

    @Operation(summary = "Получает все карточки")
    @GetMapping()
    @Override
    public ResponseEntity<List<CardResponse>> findAll() {
        return ResponseEntity.ok(cardService.findAll());
    }

    @Operation(summary = "Создает карточку")
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public ResponseEntity<CardResponse> createEntity(@RequestBody @Valid CreateCardDto entityDto) {
        return new ResponseEntity<>(cardService.createEntity(entityDto), HttpStatus.CREATED);
    }

    @Operation(summary = "Получить карточку по ее id")
    @GetMapping("/find/{id}")
    @Override
    public ResponseEntity<CardResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(cardService.findById(id));
    }

    @Operation(summary = "Обновление карточки по ее id")
    @PostMapping("/update/{id}")
    @Override
    public ResponseEntity<HttpStatus> updateEntity(@PathVariable UUID id,
                                                   @RequestBody @Valid CardRequest updatedEntityDto) {
        return ResponseEntity.ok(cardService.updateEntity(id, updatedEntityDto));
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<HttpStatus> deleteEntity(@PathVariable UUID id) {
        cardService.deleteEntity(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
