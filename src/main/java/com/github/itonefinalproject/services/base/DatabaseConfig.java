package com.github.itonefinalproject.services.base;

import com.github.itonefinalproject.services.base.exception.DatabaseConnectionException;

import java.sql.*;
import java.util.Objects;


public class DatabaseConfig {
    private static final String URL = Objects.requireNonNull(System.getenv("DATABASE_URL"));
    private static final String USER = Objects.requireNonNull(System.getenv("DATABASE_USER"));;
    private static final String PASSWORD = Objects.requireNonNull(System.getenv("DATABASE_PASSWORD"));;
    public static Connection connectToDB() throws DatabaseConnectionException {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new DatabaseConnectionException(e);
        }
    }

    public static PreparedStatement getPreparedStatement(DatabaseQuery databaseQuery) {
        try(PreparedStatement preparedStatement = connectToDB().prepareStatement(databaseQuery.name())) {
            return preparedStatement;
        } catch (DatabaseConnectionException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
