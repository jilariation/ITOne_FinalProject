package com.github.itonefinalproject.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class EmployeeDtoForEmployeeController {
    @Size(max = 100, message = "Логин не должен превыщать 100 символов")
    @NotEmpty(message = "Логин не должен быть пустым")
    private String name;

    @Email
    @Size(max = 150, message = "Email не должен превыщать 150 символов")
    @NotEmpty(message = "Email не должен быть пустым")
    private String email;

    @Size(max = 255, message = "Пароль не должен превышать 255 символов")
    @NotEmpty(message = "Пароль не должен быть пустым")
    private String password;

    private UUID deskId;
}