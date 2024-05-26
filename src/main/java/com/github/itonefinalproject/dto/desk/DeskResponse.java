package com.github.itonefinalproject.dto.desk;

import com.github.itonefinalproject.dto.AbstractDto;
import com.github.itonefinalproject.dto.card.CardResponse;
import com.github.itonefinalproject.dto.employee.EmployeeResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeskResponse extends AbstractDto {
    @NotEmpty(message = "Название не должно быть пустым")
    String name;

    List<CardResponse> cards;

    @NotBlank(message = "List с сотрудниками не может быть пустым")
    List<EmployeeResponse> employees;
}
