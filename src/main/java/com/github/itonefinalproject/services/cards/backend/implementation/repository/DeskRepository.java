package com.github.itonefinalproject.services.cards.backend.implementation.repository;

import com.github.itonefinalproject.services.base.DatabaseQuery;
import com.github.itonefinalproject.services.cards.backend.repository.AbstractRepository;
import com.github.itonefinalproject.services.cards.domain.Desk;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

import static com.github.itonefinalproject.services.base.DatabaseConfig.getPreparedStatement;

/**
 * Репозиторий для {@link Desk}
 */
@Component
public class DeskRepository extends AbstractRepository<Desk> {
    @Override
    public void createEntity(Desk entity) {
        var prep = getPreparedStatement(DatabaseQuery.DESK_CREATE);
        try {
            prep.setInt(1, entity.cardId());
            prep.setString(2, entity.name());
            prep.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Desk findById(Integer id) {
        var prep = getPreparedStatement(DatabaseQuery.DESK_FIND_BY_ID);
        try (var resultSet = prep.executeQuery()) {
                return new Desk(
                        resultSet.getInt("id"),
                        resultSet.getInt("card_id"),
                        resultSet.getString("desk_name")
                );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEntity(Integer id, Desk updatedEntity) {
        var prep = getPreparedStatement(DatabaseQuery.DESK_UPDATE);
        try {
            prep.setInt(1, updatedEntity.cardId());
            prep.setString(2, updatedEntity.name());
            prep.setInt(3, id);
            prep.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEntity(Integer id) {
        var prep = getPreparedStatement(DatabaseQuery.DESK_DELETE);
        try {
            prep.setInt(1, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
