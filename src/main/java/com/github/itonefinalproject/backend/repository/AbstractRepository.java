package com.github.itonefinalproject.backend.repository;

/**
 * Абстрактный класс для обобщения логики репозитория
 * @param <T> Сущность, для которой создается репозиторий
 */
public abstract class AbstractRepository<T> {
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
    public abstract T findById(Integer id);

    /**
     * Обновляет сущность в БД по ее ID
     * @param id ID сущности
     * @param updatedEntity Обновленная сущность
     */
    public abstract void updateEntity(Integer id, T updatedEntity);

    /**
     * Удаляет сущность из базы данных по ее ID
     * @param id ID сущности
     */
    public abstract void deleteEntity(Integer id);
}
