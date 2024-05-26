package com.github.itonefinalproject.dto.card;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCardDto {
    @NotBlank(message = "Название карточки не должно быть пустым")
    @Size(min = 1, max =  100, message = "Название карточки должно быть длинной минимум 1 и максимум 100")
    private String name;

    private List<UUID> tasksIds;

    @NotBlank(message = "Id доски не должно быть пустым")
    private UUID deskId;
}
