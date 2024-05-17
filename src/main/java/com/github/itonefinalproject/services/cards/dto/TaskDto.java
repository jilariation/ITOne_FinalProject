package com.github.itonefinalproject.services.cards.dto;

import com.github.itonefinalproject.services.cards.domain.KindOfTaskEnum;
import com.github.itonefinalproject.services.cards.domain.Task;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Dto для {@link Task}
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TaskDto extends AbstractDto {
    @NotEmpty(message = "Вид задачи не должен быть пустым")
    private KindOfTaskEnum kindOfTaskEnum;

    @Size(max = 100, message = "Название не должно превышать 100 символов")
    @NotEmpty
    private String name;

    private CardDto cardDto;
}
