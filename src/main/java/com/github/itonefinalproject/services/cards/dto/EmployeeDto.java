package com.github.itonefinalproject.services.cards.dto;

import com.github.itonefinalproject.services.cards.domain.Card;
import com.github.itonefinalproject.services.cards.domain.Desk;
import com.github.itonefinalproject.services.cards.domain.Employee;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Dto для {@link Employee}
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class EmployeeDto extends AbstractDto {
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

    private CardDto cardDto;
    private DeskDto deskDto;
}
