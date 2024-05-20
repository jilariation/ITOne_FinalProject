package com.github.itonefinalproject.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class CardDtoForCardController {
    @NotEmpty(message = "Название не должно быть пустым")
    @Size(min = 1, max =  100, message = "Название карточки должно быть длинной минимум 1 и максимум 100")
    private String name;
    @NotEmpty(message = "UUID доски не должен быть пустым")
    private UUID deskId;

    private List<TaskDtoForDeskController> tasks;
}
