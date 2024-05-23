package com.github.itonefinalproject.dto.desk;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeskRequest {
    @NotBlank(message = "Название не должно быть пустым")
    String name;
}
