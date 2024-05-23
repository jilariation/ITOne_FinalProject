package com.github.itonefinalproject.dto.card;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CardRequest {
    @NotBlank(message = "Название карточки не должно быть пустым")
    @Size(min = 1, max =  100, message = "Название карточки должно быть длинной минимум 1 и максимум 100")
    private String name;
}
