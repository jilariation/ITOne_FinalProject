package com.github.itonefinalproject.dto.desk;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class CreateDeskDto {
    @NotBlank(message = "Название не должно быть пустым")
    @Size(max = 150, message = "Название доски не должно превышать 150 символов")
    String name;

    private List<UUID> cardsId;
    private List<UUID> employeeIds;
}
