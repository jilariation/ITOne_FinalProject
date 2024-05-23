package com.github.itonefinalproject.dto.task;

import com.github.itonefinalproject.domain.enums.KindOfTaskEnum;
import com.github.itonefinalproject.dto.AbstractDto;
import com.github.itonefinalproject.dto.employee.EmployeeResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class TaskResponse extends AbstractDto {
    @NotBlank(message = "Вид задачи не должен быть пустым")
    @Size(max = 30, message = "Размер вида задачи не должен быть больше 30")
    private KindOfTaskEnum kindOfTaskEnum;

    @NotBlank(message = "Имя задачи не должно быть пустым")
    @Size(max = 100, message = "Размер названия задачи не должен превыщать 100 символов")
    private String name;

    private List<EmployeeResponse> employees;
}
