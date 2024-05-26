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
    @Size(max = 30, message = "Размер вида задачи не должен быть больше 30")
    private String kindOfTask;

    @NotBlank(message = "Имя задачи не должно быть пустым")
    @Size(max = 100, message = "Размер названия задачи не должен превыщать 100 символов")
    private String name;

    private UUID cardId;

    private List<UUID> employeeUuidsList;
}