package com.github.itonefinalproject.services.cards.domain;

public record Card(
        Integer id,
        Integer taskId,
        String name
) {
}
