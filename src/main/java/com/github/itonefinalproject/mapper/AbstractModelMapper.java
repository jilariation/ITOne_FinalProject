package com.github.itonefinalproject.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public abstract class AbstractModelMapper<ENTITY, RESP> {
    public abstract ENTITY toEntity(RESP dto);
    public abstract RESP toDto(ENTITY entity);
}
