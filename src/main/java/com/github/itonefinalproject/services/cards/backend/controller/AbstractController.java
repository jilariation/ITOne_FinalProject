package com.github.itonefinalproject.services.cards.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Абстрактный класс для обобщения логики контроллера
 * @param <D> DTO сущности
 */
public abstract class AbstractController<D> {
    public abstract ResponseEntity<HttpStatus> createEntity(@RequestBody D entityDTO);
    public abstract ResponseEntity<HttpStatus> findById(@PathVariable int id);
    public abstract ResponseEntity<HttpStatus> updateEntity(@PathVariable int id, @RequestBody D updatedEntity);
    public abstract ResponseEntity<HttpStatus> deleteEntity(@PathVariable int id);
}
