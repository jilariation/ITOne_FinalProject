package com.github.itonefinalproject.services.cards.backend.implementation.controller;

import com.github.itonefinalproject.services.cards.backend.controller.AbstractController;
import com.github.itonefinalproject.services.cards.backend.implementation.service.DeskService;
import com.github.itonefinalproject.services.cards.backend.mapper.DeskModelMapper;
import com.github.itonefinalproject.services.cards.domain.Desk;
import com.github.itonefinalproject.services.cards.dto.DeskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/desk")
@RequiredArgsConstructor
public class DeskController extends AbstractController<DeskDto> {
    private final DeskModelMapper deskModelMapper;
    private final DeskService deskService;
    @PostMapping("/create")
    @Override
    public ResponseEntity<HttpStatus> createEntity(@RequestBody DeskDto entityDTO) {
        Desk desk = deskModelMapper.toEntity(entityDTO);
        deskService.createEntity(desk);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    @Override
    public ResponseEntity<DeskDto> findById(@PathVariable int id) {
        Desk desk = deskService.findById(id);
        DeskDto deskDto = deskModelMapper.toDto(desk);
        return ResponseEntity.ok(deskDto);
    }

    @PostMapping("/update/{id}")
    @Override
    public ResponseEntity<HttpStatus> updateEntity(@PathVariable int id, @RequestBody DeskDto updatedEntity) {
        Desk desk = deskModelMapper.toEntity(updatedEntity);
        deskService.updateEntity(id, desk);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<HttpStatus> deleteEntity(@PathVariable int id) {
        deskService.deleteEntity(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
