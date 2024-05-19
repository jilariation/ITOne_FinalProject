package com.github.itonefinalproject.dto;

import com.github.itonefinalproject.domain.Card;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

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
