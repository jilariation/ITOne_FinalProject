package com.github.itonefinalproject.dto.employee;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {
    @Size(max = 100, message = "Логин не должен превыщать 100 символов")
    @NotBlank(message = "Логин не должен быть пустым")
    private String name;

    private List<UUID> desksUuidsList;
    private List<UUID> tasksUuidsList;
}
