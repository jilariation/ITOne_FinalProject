package com.github.itonefinalproject.services.cards.backend.implementation.repository;

import com.github.itonefinalproject.services.base.DatabaseQuery;
import com.github.itonefinalproject.services.cards.backend.repository.AbstractRepository;
import com.github.itonefinalproject.services.cards.domain.Employee;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

import static com.github.itonefinalproject.services.base.DatabaseConfig.getPreparedStatement;

/**
 * Репозиторий для {@link Employee}
 */
@Component
public class EmployeeRepository extends AbstractRepository<Employee> {

    @Override
    public void createEntity(Employee entity) {
        var prep = getPreparedStatement(DatabaseQuery.EMPLOYEE_CREATE);
        try {
            prep.setString(1, entity.firstName());
            prep.setString(2, entity.lastName());
            prep.setString(3, entity.surname());
            prep.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employee findById(Integer id) {
        var prep = getPreparedStatement(DatabaseQuery.EMPLOYEE_FIND_BY_ID);
        try {
            prep.setInt(1, id);
            try(var resultSet = prep.executeQuery()) {
                return new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("surname")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEntity(Integer id, Employee updatedEntity) {
        var prep = getPreparedStatement(DatabaseQuery.EMPLOYEE_UPDATE);
        try {
            prep.setString(1, updatedEntity.firstName());
            prep.setString(2, updatedEntity.lastName());
            prep.setString(3, updatedEntity.surname());
            prep.setInt(4, id);
            prep.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void deleteEntity(Integer id) {
        var prep = getPreparedStatement(DatabaseQuery.EMPLOYEE_DELETE);
        try {
            prep.setInt(1, id);
            prep.executeQuery();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
