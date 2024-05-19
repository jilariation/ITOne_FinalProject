package com.github.itonefinalproject.dto;

import com.github.itonefinalproject.domain.Card;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

/**
 * Dto для {@link Card}
 */
@Data
public class CardDto {
    @NotEmpty(message = "Название не должно быть пустым")
    @Size(min = 1, max =  100, message = "Название карточки должно быть длинной минимум 1 и максимум 100")
    private String name;

    private List<TaskDto> tasks;
}
