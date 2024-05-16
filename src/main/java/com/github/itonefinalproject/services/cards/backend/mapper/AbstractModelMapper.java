package com.github.itonefinalproject.services.cards.backend.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public abstract class AbstractModelMapper<C, D> {
    public abstract C toEntity(D dto);
    public abstract D toDto(C entity);
}
