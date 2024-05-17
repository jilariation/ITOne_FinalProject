package com.github.itonefinalproject.services.cards.backend.service;

import java.util.UUID;

/**
 * Абстрактный класс для обобщения логики сервиса
 * @param <T> Тип сущность, для которой создается сервис
 */
public abstract class AbstractService<T> {
    /**
     * Добавление сущности в базу данных
     * @param entity Сущность, которую нужно добавить
     */
    public abstract void createEntity(T entity);

    /**
     * Получить сущность по ее ID
     * @param id ID сущности
     * @return Возращает найденную сущность
     */
    public abstract T findById(UUID id);

    /**
     * Обновляет сущность в БД по ее ID
     * @param id ID сущности
     * @param updatedEntity Обновленная сущность
     */
    public abstract void updateEntity(UUID id, T updatedEntity);

    /**
     * Удаляет сущность из базы данных по ее ID
     * @param id ID сущности
     */
    public abstract void deleteEntity(UUID id);
}
