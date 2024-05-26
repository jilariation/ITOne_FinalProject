package com.github.itonefinalproject.dto.employee;

import com.github.itonefinalproject.dto.AbstractDto;
import com.github.itonefinalproject.dto.desk.DeskResponse;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse extends AbstractDto {
    @Size(max = 100, message = "Логин не должен превыщать 100 символов")
    @NotBlank(message = "Логин не должен быть пустым")
    private String name;

    @Email
    @Size(max = 150, message = "Email не должен превыщать 150 символов")
    @NotBlank(message = "Email не должен быть пустым")
    private String email;
}
