package com.github.itonefinalproject.implementation.controller;

import com.github.itonefinalproject.controller.AbstractController;
import com.github.itonefinalproject.domain.Desk;
import com.github.itonefinalproject.dto.card.CreateCardDto;
import com.github.itonefinalproject.dto.desk.CreateDeskDto;
import com.github.itonefinalproject.dto.desk.DeskRequest;
import com.github.itonefinalproject.dto.desk.DeskResponse;
import com.github.itonefinalproject.service.DeskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Rest контроллер для взаимодействия с {@link Desk}
 */
@RestController
@RequestMapping("/desks")
@RequiredArgsConstructor
@Tag(name = "Desks", description = "Контроллер для работы с досками")
public class DeskController extends AbstractController<DeskRequest, DeskResponse, CreateDeskDto> {

    private final DeskService deskService;

    @Operation(summary = "Получает все доски")
    @GetMapping()
    @Override
    public ResponseEntity<List<DeskResponse>> findAll() {
        return ResponseEntity.ok(deskService.findAll());
    }

    @Operation(summary = "Добавить доску")
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public ResponseEntity<DeskResponse> createEntity(@RequestBody @Valid CreateDeskDto entityDto) {
        return new ResponseEntity<>(deskService.createEntity(entityDto), HttpStatus.CREATED);
    }

    @Operation(summary = " Получить доску через его id")
    @GetMapping("/find/{id}")
    @Override
    public ResponseEntity<DeskResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(deskService.findById(id));
    }

    @Operation(summary = "Обновление доски по ее id")
    @PostMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public ResponseEntity<DeskResponse> updateEntity(@PathVariable UUID id,
                                                     @RequestBody @Valid DeskRequest updatedEntityDto) {
        return ResponseEntity.ok(deskService.updateEntity(id, updatedEntityDto));
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<HttpStatus> deleteEntity(@PathVariable UUID id) {
        deskService.deleteEntity(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
