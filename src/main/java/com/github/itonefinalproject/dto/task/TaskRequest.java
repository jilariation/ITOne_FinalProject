package com.github.itonefinalproject.dto.task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest {
    private List<String> kindOfTaskList;

    @NotBlank(message = "Имя задачи не должно быть пустым")
    @Size(max = 100, message = "Размер названия задачи не должен превыщать 100 символов")
    private String name;

    @NotBlank(message = "Id карточки не должен быть пустым")
    private UUID cardId;

    @NotBlank(message = "Id сотрудника не должен быть пустым")
    private List<UUID> employeeUuidsList;
}