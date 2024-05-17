package com.github.itonefinalproject.services.cards.dto;

import com.github.itonefinalproject.services.cards.domain.Desk;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Dto для {@link Desk}
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DeskDto extends AbstractDto {
    @NotEmpty(message = "Название не должно быть пустым")
    String name;

    List<CardDto> cards;
    List<EmployeeDto> employees;
}