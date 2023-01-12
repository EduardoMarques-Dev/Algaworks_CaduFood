package com.algaworks.cadufood.api.mapper;

import com.algaworks.cadufood.api.model.input.CozinhaInput;
import com.algaworks.cadufood.api.model.output.CozinhaOutput;
import com.algaworks.cadufood.core.generic.mapper.GenericMapper;
import com.algaworks.cadufood.domain.model.Cozinha;
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
public class CozinhaMapper implements GenericMapper<Cozinha, CozinhaInput, CozinhaOutput> {

    private ModelMapper modelMapper;

    @Override
    public Cozinha toDomain(CozinhaInput cozinhaInput) {
        return modelMapper.map(cozinhaInput, Cozinha.class);
    }

    @Override
    public CozinhaOutput toOutput(Cozinha cozinha) {
        return modelMapper.map(cozinha, CozinhaOutput.class);
    }

    @Override
    public List<Cozinha> toDomainCollection(List<CozinhaInput> cozinhaInputs) {
        return cozinhaInputs.stream()
                .map(dto -> toDomain(dto))
                .collect(Collectors.toList());
    }

    @Override
    public List<CozinhaOutput> toOutputCollection(List<Cozinha> cozinhas) {
        return cozinhas.stream()
                .map(entity -> toOutput(entity))
                .collect(Collectors.toList());
    }

    @Override
    public Page<CozinhaOutput> toOutputCollection(Page<Cozinha> cozinhas) {
        return new PageImpl<>(toOutputCollection(cozinhas.toList()));
    }

    @Override
    public void updateEntity(CozinhaInput newEntity, Cozinha currentEntity) {
        modelMapper.map(newEntity, currentEntity);
    }

    @Override
    public void patchEntity(HashMap<String, Object> fields, Cozinha currentEntity) {
        modelMapper.map(fields, currentEntity);
    }

}
