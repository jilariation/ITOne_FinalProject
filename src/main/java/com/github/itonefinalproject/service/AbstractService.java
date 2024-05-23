package com.github.itonefinalproject.service;

import java.util.List;
import java.util.UUID;

/**
 * Абстрактный класс для обобщения логики сервиса
 * @param <TYPE> Тип сущность, для которой создается сервис
 * @param <RESP> Response dto сущности
 * @param <REQ> Request dto сущности
 */
public interface AbstractService<TYPE, RESP, REQ> {
    /**
     * Добавление сущности в базу данных
     * @param entityDto Сущность, которую нужно добавить
     */
    REQ createEntity(REQ entityDto);

    /**
     * Получить сущность по ее ID
     * @param id ID сущности
     * @return Возращает найденную сущность
     */
    RESP findById(UUID id);

    /**
     * Обновляет сущность в БД по ее ID
     * @param id ID сущности
     * @param updatedEntityDto Обновленная сущность
     */
    void updateEntity(UUID id, REQ updatedEntityDto);

    /**
     * Удаляет сущность из базы данных по ее ID
     * @param id ID сущности
     */
    void deleteEntity(UUID id);

    /**
     * Возращает все сущности
     * @return Возращает List со всеми сущностями
     */
    List<RESP> findAll();
}
