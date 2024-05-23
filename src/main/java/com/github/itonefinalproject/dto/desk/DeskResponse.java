package com.github.itonefinalproject.dto.desk;

import com.github.itonefinalproject.dto.AbstractDto;
import com.github.itonefinalproject.dto.card.CardResponse;
import com.github.itonefinalproject.dto.employee.EmployeeResponse;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class DeskResponse extends AbstractDto {
    @NotEmpty(message = "Название не должно быть пустым")
    String name;

    List<CardResponse> cards;
    List<EmployeeResponse> employees;
}
