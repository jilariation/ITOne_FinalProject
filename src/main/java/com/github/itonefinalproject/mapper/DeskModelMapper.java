package com.github.itonefinalproject.mapper;

import com.github.itonefinalproject.domain.Desk;
import com.github.itonefinalproject.dto.card.CardResponse;
import com.github.itonefinalproject.dto.desk.CreateDeskDto;
import com.github.itonefinalproject.dto.desk.DeskRequest;
import com.github.itonefinalproject.dto.desk.DeskResponse;
import com.github.itonefinalproject.dto.employee.EmployeeResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DeskModelMapper extends AbstractModelMapper<Desk, DeskRequest, DeskResponse>{
    private final ModelMapper modelMapper;
    private final EmployeeModelMapper employeeModelMapper;
    private final CardModelMapper cardModelMapper;

    @Override
    public Desk toEntity(DeskResponse dto) {
        return null;
    }

    @Override
    public DeskResponse toDto(Desk desk) {
        List<EmployeeResponse> employeeResponseList = desk.getEmployees().stream()
                .map(employeeModelMapper::toDto)
                .collect(Collectors.toList());
        List<CardResponse> cardResponseList = desk.getCards().stream()
                .map(cardModelMapper::toDto)
                .collect(Collectors.toList());

        DeskResponse deskResponse = modelMapper.map(desk, DeskResponse.class);
        deskResponse.setEmployees(employeeResponseList);
        deskResponse.setCards(cardResponseList);

        return deskResponse;
    }

    public Desk toEntity(CreateDeskDto createDeskDto) {
        return modelMapper.map(createDeskDto, Desk.class);
    }

    public void toEntity(Desk desk, DeskRequest deskRequest) {
        modelMapper.map(deskRequest, desk);
    }
}
