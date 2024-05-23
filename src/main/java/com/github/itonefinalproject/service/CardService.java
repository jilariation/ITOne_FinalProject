package com.github.itonefinalproject.service;

import com.github.itonefinalproject.domain.Card;
import com.github.itonefinalproject.domain.Employee;
import com.github.itonefinalproject.dto.card.CardRequest;
import com.github.itonefinalproject.dto.card.CardResponse;
import com.github.itonefinalproject.dto.employee.EmployeeResponse;

import java.util.List;
import java.util.UUID;

public interface CardService extends AbstractService<Card, CardResponse, CardRequest> {
    /**
     * Находит dto всех {@link Card} по их ID
     * @param uuid ID {@link Card}
     * @return Возращает List со всеми {@link Card}
     */
    List<CardResponse> getCardsById(List<UUID> uuid);
}
