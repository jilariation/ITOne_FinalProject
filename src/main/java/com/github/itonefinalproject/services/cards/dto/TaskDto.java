package com.github.itonefinalproject.services.cards.dto;

import lombok.Getter;

import java.sql.Date;

@Getter
public class TaskDto {
    private Integer kindOfTaskId;
    private Integer employeeId;
    private String name;
    private Date date;
}
