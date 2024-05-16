package com.github.itonefinalproject.services.base.exception;

import java.sql.SQLException;

public class DatabaseConnectionException extends Exception {
    public DatabaseConnectionException(SQLException message) {
        super(message);
    }
}
