package com.github.itonefinalproject.dto.desk;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeskRequest {
    @Size(max = 100, message = "Название доски не должно быть больше 100 символов")
    @NotBlank(message = "Название не должно быть пустым")
    String name;
}
