package com.github.itonefinalproject.backend.implementation.controller;

import com.github.itonefinalproject.domain.Desk;
import com.github.itonefinalproject.dto.DeskDtoForDeskController;
import com.github.itonefinalproject.backend.controller.AbstractController;
import com.github.itonefinalproject.backend.implementation.service.DeskService;
import com.github.itonefinalproject.backend.mapper.DeskModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Rest контроллер для взаимодействия с {@link Desk}
 */
@RestController
@RequestMapping("/desks")
@RequiredArgsConstructor
public class DeskController extends AbstractController<DeskDtoForDeskController> {
    private final DeskModelMapper deskModelMapper;
    private final DeskService deskService;

    @GetMapping()
    public List<DeskDtoForDeskController> findAllDesks() {
        return deskService.findAll()
                .stream()
                .map(deskModelMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/create")
    @Override
    public ResponseEntity<HttpStatus> createEntity(@RequestBody DeskDtoForDeskController entityDTO) {
        Desk desk = deskModelMapper.toEntity(entityDTO);
        deskService.createEntity(desk);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<DeskDtoForDeskController> findById(@PathVariable UUID id) {
        Desk desk = deskService.findById(id);
        DeskDtoForDeskController deskDtoForDeskController = deskModelMapper.toDto(desk);
        return ResponseEntity.ok(deskDtoForDeskController);
    }

    @PostMapping("/update/{id}")
    @Override
    public ResponseEntity<HttpStatus> updateEntity(@PathVariable UUID id, @RequestBody DeskDtoForDeskController updatedEntity) {
        Desk desk = deskModelMapper.toEntity(updatedEntity);
        deskService.updateEntity(id, desk);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<HttpStatus> deleteEntity(@PathVariable UUID id) {
        deskService.deleteEntity(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
