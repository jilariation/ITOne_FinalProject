package com.github.itonefinalproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

/**
 *  Абстрактный класс для обобщения логики контроллера
 * @param <REQ> Request dto сущности
 * @param <RESP> Response dto сущности
 */
public abstract class AbstractController<REQ, RESP, CREATE> {
    public abstract ResponseEntity<List<RESP>> findAll();
    public abstract ResponseEntity<RESP> createEntity(CREATE entityDto);
    public abstract ResponseEntity<RESP> findById(UUID id);
    public abstract ResponseEntity<RESP> updateEntity(UUID id, REQ updatedEntityDto);
    public abstract ResponseEntity<HttpStatus> deleteEntity(UUID id);
}
