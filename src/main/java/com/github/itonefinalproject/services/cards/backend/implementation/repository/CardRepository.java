package com.github.itonefinalproject.services.cards.backend.implementation.repository;

import com.github.itonefinalproject.services.base.DatabaseQuery;
import com.github.itonefinalproject.services.cards.backend.repository.AbstractRepository;
import com.github.itonefinalproject.services.cards.domain.Card;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.github.itonefinalproject.services.base.DatabaseConfig.getPreparedStatement;

/**
 * Репозиторий для {@link Card}
 */
@Component
public class CardRepository extends AbstractRepository<Card> {
    @Override
    public void createEntity(Card entity) {
        var prep = getPreparedStatement(DatabaseQuery.CARD_CREATE);
        try {
            prep.setInt(1, entity.taskId());
            prep.setString(2, entity.name());
            prep.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Card findById(Integer id) {
        var prep = getPreparedStatement(DatabaseQuery.CARD_FIND_BY_ID);
        try(ResultSet resultSet = prep.executeQuery()) {
            return new Card(
                    resultSet.getInt("id"),
                    resultSet.getInt("task_id"),
                    resultSet.getString("card_name")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEntity(Integer id, Card updatedEntity) {
        var prep = getPreparedStatement(DatabaseQuery.CARD_UPDATE);
        try {
            prep.setInt(1, updatedEntity.taskId());
            prep.setString(2, updatedEntity.name());
            prep.setInt(3, id);
            prep.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEntity(Integer id) {
        var prep = getPreparedStatement(DatabaseQuery.CARD_DELETE);
        try {
            prep.setInt(1, id);
            prep.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
