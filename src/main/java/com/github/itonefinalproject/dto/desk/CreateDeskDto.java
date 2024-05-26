package com.github.itonefinalproject.dto.desk;

import jakarta.validation.constraints.NotBlank;
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
public class CreateDeskDto {
    @Size(max = 100, message = "Название доски не должно быть больше 100 символов")
    @NotBlank(message = "Название не должно быть пустым")
    String name;

    private List<UUID> cardUuidsList;
    private List<UUID> employeeUuidsList;
}
