package com.github.itonefinalproject.services.cards.dto;

import com.github.itonefinalproject.services.cards.domain.Card;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Dto для {@link Card}
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CardDto extends AbstractDto {
    @NotEmpty(message = "Название не должно быть пустым")
    @Size(min = 1, max =  100, message = "Название карточки должно быть длинной минимум 1 и максимум 100")
    private String name;

    private List<TaskDto> tasks;
    private List<EmployeeDto> employees;

    @NotEmpty(message = "Карточка должна быть в какой-либо доске")
    private DeskDto deskDto;
}
