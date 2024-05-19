package com.github.itonefinalproject.backend.implementation.controller;

import com.github.itonefinalproject.domain.Desk;
import com.github.itonefinalproject.dto.DeskDto;
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
public class DeskController extends AbstractController<DeskDto> {
    private final DeskModelMapper deskModelMapper;
    private final DeskService deskService;

    @GetMapping()
    public List<DeskDto> findAllDesks() {
        return deskService.findAll().stream()
                .map(deskModelMapper::toDto).collect(Collectors.toList());
    }

    @PostMapping("/create")
    @Override
    public ResponseEntity<HttpStatus> createEntity(@RequestBody DeskDto entityDTO) {
        Desk desk = deskModelMapper.toEntity(entityDTO);
        deskService.createEntity(desk);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<DeskDto> findById(@PathVariable UUID id) {
        Desk desk = deskService.findById(id);
        DeskDto deskDto = deskModelMapper.toDto(desk);
        return ResponseEntity.ok(deskDto);
    }

    @PostMapping("/update/{id}")
    @Override
    public ResponseEntity<HttpStatus> updateEntity(@PathVariable UUID id, @RequestBody DeskDto updatedEntity) {
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
