package com.algaworks.cadufood.api.mapper;

import com.algaworks.cadufood.api.model.input.RestauranteInput;
import com.algaworks.cadufood.api.model.output.RestauranteOutput;
import com.algaworks.cadufood.core.generic.mapper.DetachedKeyMapper;
import com.algaworks.cadufood.domain.model.Cidade;
import com.algaworks.cadufood.domain.model.Cozinha;
import com.algaworks.cadufood.domain.model.Restaurante;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


@Component
@AllArgsConstructor
public class RestauranteMapper implements DetachedKeyMapper<Restaurante, RestauranteInput, RestauranteOutput> {

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
        detachForeignKey(currentEntity);
        modelMapper.map(newEntity, currentEntity);
    }

    @Override
    public void patchEntity(HashMap<String, Object> fields, Restaurante currentEntity) {
        detachForeignKey(currentEntity);
        modelMapper.map(fields, currentEntity);
    }

    @Override
    public void detachForeignKey(Restaurante restaurante) {
        Long cozinhaId = restaurante.getCozinha().getId();
        restaurante.setCozinha(new Cozinha());
        restaurante.getCozinha().setId(cozinhaId);

        if (restaurante.getEndereco() != null
            && restaurante.getEndereco().getCidade() != null){
            Long cidadeId = restaurante.getEndereco().getCidade().getId();
            restaurante.getEndereco().setCidade(new Cidade());
            restaurante.getEndereco().getCidade().setId(cidadeId);
        }
    }
}
