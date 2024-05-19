package com.github.itonefinalproject.dto;

import com.github.itonefinalproject.domain.Desk;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Dto для {@link Desk}
 */
@Data
public class DeskDto {
    @NotEmpty(message = "Название не должно быть пустым")
    String name;

    List<CardDto> cards;
    List<EmployeeDto> employees;
}