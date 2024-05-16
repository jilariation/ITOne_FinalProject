package com.github.itonefinalproject.services.cards.domain;

import lombok.Builder;

import java.sql.Date;

@Builder
public record Task(
        Integer id,
        Integer kindOfTaskId,
        Integer employeeId,
        String name,
        Date date
) {
}
