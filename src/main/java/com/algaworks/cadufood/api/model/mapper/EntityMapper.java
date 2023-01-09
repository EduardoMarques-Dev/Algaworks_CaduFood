package com.algaworks.cadufood.api.model.mapper;

import org.springframework.data.domain.Page;

import java.util.List;

public interface EntityMapper<Entity, Dto> {

    Entity toEntity(Dto dto);

    Dto toDto(Entity entity);

    List<Entity> toEntityCollection(List<Dto> dtoList);

    List<Dto> toDtoCollection(List<Entity> entityList);

    Page<Dto> toDtoCollection(Page<Entity> entityList);

}
