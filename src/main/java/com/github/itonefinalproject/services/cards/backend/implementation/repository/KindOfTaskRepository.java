package com.github.itonefinalproject.services.cards.backend.implementation.repository;


import com.github.itonefinalproject.services.base.DatabaseQuery;
import com.github.itonefinalproject.services.cards.backend.repository.AbstractRepository;
import com.github.itonefinalproject.services.cards.domain.KindOfTask;
import com.github.itonefinalproject.services.cards.domain.KindOfTaskEnum;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

import static com.github.itonefinalproject.services.base.DatabaseConfig.getPreparedStatement;

/**
 * Репозиторий для {@link KindOfTask}
 */
@Component
public class KindOfTaskRepository extends AbstractRepository<KindOfTask> {
    public void createEntity(KindOfTask entity) {
        var prep = getPreparedStatement(DatabaseQuery.CREATE);
        try {
            prep.setString(1, entity.kindOfTaskEnum().name());
            prep.executeQuery();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public KindOfTask findById(Integer id) {
        var prep = getPreparedStatement(DatabaseQuery.FIND_BY_ID);
        try {
            try {
                prep.setInt(1, id);
                try(var resultSet = prep.executeQuery()) {
                    return new KindOfTask(
                            resultSet.getInt("id"),
                            KindOfTaskEnum.fromString(resultSet.getString("kind_of_task")
                    ));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateEntity(Integer id, KindOfTask updatedEntity ) {
        var prep = getPreparedStatement(DatabaseQuery.UPDATE);
        try {
            prep.setString(1, updatedEntity.kindOfTaskEnum().name());
            prep.setInt(2, id);
            prep.executeQuery();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void deleteEntity(Integer id) {
        var prep = getPreparedStatement(DatabaseQuery.DELETE);
        try {
            prep.setInt(1, id);
            prep.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}