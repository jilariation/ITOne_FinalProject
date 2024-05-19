package com.github.itonefinalproject.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

/**
 * Абстрактный класс для обобщения логики контроллера
 * @param <D> DTO сущности
 */
public abstract class AbstractController<D> {
    public abstract ResponseEntity<HttpStatus> createEntity(@RequestBody D entityDTO);
    public abstract ResponseEntity<D> findById(@PathVariable UUID id);
    public abstract ResponseEntity<HttpStatus> updateEntity(@PathVariable UUID id, @RequestBody D updatedEntity);
    public abstract ResponseEntity<HttpStatus> deleteEntity(@PathVariable UUID id);
}
