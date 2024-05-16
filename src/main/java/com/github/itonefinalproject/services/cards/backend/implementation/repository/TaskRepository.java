package com.github.itonefinalproject.services.cards.backend.implementation.repository;

import com.github.itonefinalproject.services.base.DatabaseQuery;
import com.github.itonefinalproject.services.cards.backend.repository.AbstractRepository;
import com.github.itonefinalproject.services.cards.domain.Task;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

import static com.github.itonefinalproject.services.base.DatabaseConfig.getPreparedStatement;

/**
 * Репозиторий для {@link Task}
 */
@Component
public class TaskRepository extends AbstractRepository<Task> {
    @Override
    public void createEntity(Task entity) {
        var prep = getPreparedStatement(DatabaseQuery.TASK_CREATE);
        try {
            prep.setInt(1, entity.kindOfTaskId());
            prep.setInt(2, entity.employeeId());
            prep.setString(3, entity.name());
            prep.setDate(4, entity.date());
            prep.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Task findById(Integer id) {
        var prep = getPreparedStatement(DatabaseQuery.TASK_FIND_BY_ID);
        try {
            prep.setInt(1, id);
            try(var resultSet = prep.executeQuery()) {
                return new Task(
                        resultSet.getInt("id"),
                        resultSet.getInt("kind_of_task_id"),
                        resultSet.getInt("employee_id"),
                        resultSet.getString("task_name"),
                        resultSet.getDate("task_date")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEntity(Integer id, Task updatedEntity) {
        var prep = getPreparedStatement(DatabaseQuery.TASK_UPDATE);
        try {
            prep.setInt(1, updatedEntity.kindOfTaskId());
            prep.setInt(2, updatedEntity.employeeId());
            prep.setString(3, updatedEntity.name());
            prep.setDate(4, updatedEntity.date());
            prep.setInt(5, updatedEntity.id());
            prep.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEntity(Integer id) {
        var prep = getPreparedStatement(DatabaseQuery.TASK_DELETE);
        try {
            prep.setInt(1, id);
            prep.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
