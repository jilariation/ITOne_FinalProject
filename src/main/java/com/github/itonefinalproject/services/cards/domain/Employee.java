package com.github.itonefinalproject.services.cards.domain;

import lombok.Builder;

@Builder
public record Employee(
        Integer id,
        String firstName,
        String lastName,
        String surname
) {
}
