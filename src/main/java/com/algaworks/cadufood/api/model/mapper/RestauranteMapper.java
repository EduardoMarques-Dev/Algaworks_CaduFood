package com.algaworks.cadufood.api.model.mapper;

import com.algaworks.cadufood.api.model.RestauranteDto;
import com.algaworks.cadufood.domain.model.Cozinha;
import com.algaworks.cadufood.domain.model.Restaurante;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
@AllArgsConstructor
public class RestauranteMapper implements EntityMapper<Restaurante, RestauranteDto> {

    private ModelMapper modelMapper;

    public Restaurante toEntity(RestauranteDto dto) {
        return modelMapper.map(dto, Restaurante.class);
    }

    public RestauranteDto toDto(Restaurante entity) {
        return modelMapper.map(entity, RestauranteDto.class);
    }

    public List<Restaurante> toEntityCollection(List<RestauranteDto> dtoList) {
        return dtoList.stream()
                .map(input -> toEntity(input))
                .collect(Collectors.toList());
    }

    public List<RestauranteDto> toDtoCollection(List<Restaurante> entityList) {
        return entityList.stream()
                .map(domain -> toDto(domain))
                .collect(Collectors.toList());
    }

    public Page<RestauranteDto> toDtoCollection(Page<Restaurante> entityList) {
        return new PageImpl<>(toDtoCollection(entityList.toList()));
    }

    public void copyToEntity(RestauranteDto restauranteDto, Restaurante restaurante){
        // Para evitar exception onde ao alterar o id da cozinha, o jpa tenta alterar de uma cozinha já carregada
        // o que é proibido
        restaurante.setCozinha(new Cozinha());
        modelMapper.map(restauranteDto, restaurante);
    }

}
