package com.github.itonefinalproject.dto;

import com.github.itonefinalproject.domain.KindOfTaskEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class TaskDtoForTaskController {
    @NotEmpty(message = "Вид задачи не должен быть пустым")
    @Size(max = 30, message = "Размер вида задачи не должен быть больше 30")
    private KindOfTaskEnum kindOfTaskEnum;
    @NotEmpty(message = "Имя задачи не должно быть пустым")
    @Size(max = 100, message = "Размер названия задачи не должен превыщать 100 символов")
    private String name;

    @NotEmpty(message = "ID карточки не должно быть пустым")
    private UUID cardId;

    @NotEmpty(message = "ID работника не должно быть пустым")
    private UUID employeeId;
}
