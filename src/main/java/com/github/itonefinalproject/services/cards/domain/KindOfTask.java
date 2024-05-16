package com.github.itonefinalproject.services.cards.domain;

import lombok.Builder;

@Builder
public record KindOfTask(
        Integer id,
        KindOfTaskEnum kindOfTaskEnum
) {

}
