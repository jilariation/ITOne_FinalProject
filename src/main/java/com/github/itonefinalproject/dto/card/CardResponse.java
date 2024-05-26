package com.github.itonefinalproject.dto.card;

import com.github.itonefinalproject.dto.AbstractDto;
import com.github.itonefinalproject.dto.desk.DeskResponse;
import com.github.itonefinalproject.dto.task.TaskResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardResponse extends AbstractDto {
    @NotBlank(message = "Название карточки не должно быть пустым")
    @Size(min = 1, max =  100, message = "Название карточки должно быть длинной минимум 1 и максимум 100")
    private String name;

    private List<TaskResponse> tasks;
}
