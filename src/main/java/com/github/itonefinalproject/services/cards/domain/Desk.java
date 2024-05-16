package com.github.itonefinalproject.services.cards.domain;

import lombok.Builder;

@Builder
public record Desk(
        Integer id,
        Integer cardId,
        String name
) {
}
