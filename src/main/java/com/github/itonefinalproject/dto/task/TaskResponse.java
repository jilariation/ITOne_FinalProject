package com.github.itonefinalproject.dto.task;

import com.github.itonefinalproject.dto.AbstractDto;
import com.github.itonefinalproject.dto.employee.EmployeeResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponse extends AbstractDto {
    @NotBlank(message = "Вид задачи не должен быть пустым")
    @Size(max = 30, message = "Размер вида задачи не должен быть больше 30")
    private String kindOfTask;

    @NotBlank(message = "Имя задачи не должно быть пустым")
    @Size(max = 100, message = "Размер названия задачи не должен превыщать 100 символов")
    private String name;

    private List<EmployeeResponse> employees;
}
