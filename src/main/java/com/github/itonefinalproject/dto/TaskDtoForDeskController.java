package com.github.itonefinalproject.dto;

import com.github.itonefinalproject.domain.KindOfTaskEnum;
import com.github.itonefinalproject.domain.Task;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Dto для {@link Task}
 */
@Data
public class TaskDtoForDeskController {
    @NotEmpty(message = "Вид задачи не должен быть пустым")
    private KindOfTaskEnum kindOfTaskEnum;

    @Size(max = 100, message = "Название не должно превышать 100 символов")
    @NotEmpty
    private String name;
}
