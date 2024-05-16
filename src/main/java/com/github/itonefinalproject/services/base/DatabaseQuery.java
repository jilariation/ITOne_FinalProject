package com.github.itonefinalproject.services.base;

public enum DatabaseQuery {
    FIND_BY_ID("select id, kind_of_task from kind_of_task where id = ?"),
    CREATE("insert into kind_of_task(kind_of_task) values (?)"),
    UPDATE("update kind_of_task set kind_of_task = ? where id = ?"),
    DELETE("delete from kind_of_task where id = ?"),
    TASK_FIND_BY_ID("select id, kind_of_task_id, employee_id, task_name, task_date from task where id = ?"),
    TASK_CREATE("insert into task (kind_of_task_id, employee_id, task_name, task_date) values (?,?,?,?)"),
    TASK_UPDATE("update task set kind_of_task_id = ?, employee_id = ?, task_name = ?, task_date = ? where id = ?"),
    TASK_DELETE("delete from task where id = ?"),
    EMPLOYEE_FIND_BY_ID("select id, first_name, last_name, surname from employee where id = ?"),
    EMPLOYEE_CREATE("insert into employee(first_name, last_name, surname) VALUES (?,?,?)"),
    EMPLOYEE_UPDATE("update employee set first_name = ?, last_name = ?, surname = ? where id = ?"),
    EMPLOYEE_DELETE("delete from employee where id = ?"),
    CARD_FIND_BY_ID("select id, task_id, card_name from card where id = ?"),
    CARD_CREATE("insert into card (task_id, card_name) VALUES (?, ?)"),
    CARD_UPDATE("update card set task_id = ?, card_name = ? where id = ?;"),
    CARD_DELETE("delete from card where id = ?"),
    DESK_FIND_BY_ID("select id, task_id, card_name from card where id = ?"),
    DESK_CREATE("insert into card (task_id, card_name) VALUES (?, ?)"),
    DESK_UPDATE("update card set task_id = ?, card_name = ? where id = ?;"),
    DESK_DELETE("delete from card where id = ?");
    DatabaseQuery(String s) {}
}
