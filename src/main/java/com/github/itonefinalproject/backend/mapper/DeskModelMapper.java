package com.github.itonefinalproject.backend.mapper;

import com.github.itonefinalproject.domain.Desk;
import com.github.itonefinalproject.dto.DeskDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class DeskModelMapper extends AbstractModelMapper<Desk, DeskDto>{
    private final ModelMapper modelMapper;
    @Override
    public Desk toEntity(DeskDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Desk.class);
    }

    @Override
    public DeskDto toDto(Desk entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, DeskDto.class);
    }
}
