package com.algaworks.cadufood.api.mapper;

import com.algaworks.cadufood.api.mapper.util.GenericMapper;
import com.algaworks.cadufood.api.model.input.RestauranteInput;
import com.algaworks.cadufood.api.model.output.RestauranteOutput;
import com.algaworks.cadufood.domain.model.Cidade;
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
public class RestauranteMapper implements GenericMapper<Restaurante, RestauranteInput, RestauranteOutput> {

    private ModelMapper modelMapper;

    @Override
    public Restaurante toDomain(RestauranteInput restauranteInput) {
        return modelMapper.map(restauranteInput, Restaurante.class);
    }

    @Override
    public RestauranteOutput toOutput(Restaurante restaurante) {
        return modelMapper.map(restaurante, RestauranteOutput.class);
    }

    @Override
    public List<Restaurante> toDomainCollection(List<RestauranteInput> restauranteInputs) {
        return restauranteInputs.stream()
                .map(dto -> toDomain(dto))
                .collect(Collectors.toList());
    }

    @Override
    public List<RestauranteOutput> toOutputCollection(List<Restaurante> restaurantes) {
        return restaurantes.stream()
                .map(entity -> toOutput(entity))
                .collect(Collectors.toList());
    }

    @Override
    public Page<RestauranteOutput> toOutputCollection(Page<Restaurante> restaurantes) {
        return new PageImpl<>(toOutputCollection(restaurantes.toList()));
    }

    @Override
    public void updateEntity(RestauranteInput newEntity, Restaurante currentEntity) {
        // Para evitar exception onde ao alterar o id da cozinha, o jpa tenta alterar de uma cozinha já carregada
        // o que é proibido
        currentEntity.setCozinha(new Cozinha());

        if (currentEntity.getEndereco() != null) {
            currentEntity.getEndereco().setCidade(new Cidade());
        }

        modelMapper.map(newEntity, currentEntity);
    }

}
