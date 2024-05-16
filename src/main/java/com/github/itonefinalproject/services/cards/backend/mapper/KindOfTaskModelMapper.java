package com.github.itonefinalproject.services.cards.backend.mapper;

import com.github.itonefinalproject.services.cards.domain.KindOfTask;
import com.github.itonefinalproject.services.cards.dto.KindOfTaskDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class KindOfTaskModelMapper extends AbstractModelMapper<KindOfTask, KindOfTaskDto> {
    private final ModelMapper modelMapper;

    @Override
    public KindOfTask toEntity(KindOfTaskDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, KindOfTask.class);
    }

    @Override
    public KindOfTaskDto toDto(KindOfTask entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, KindOfTaskDto.class);
    }
}
