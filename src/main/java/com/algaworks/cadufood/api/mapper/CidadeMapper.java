package com.algaworks.cadufood.api.mapper;


import com.algaworks.cadufood.api.model.input.CidadeInput;
import com.algaworks.cadufood.api.model.output.CidadeOutput;
import com.algaworks.cadufood.core.generic.crud.GenericMapper;
import com.algaworks.cadufood.domain.model.Cidade;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CidadeMapper implements GenericMapper<Cidade, CidadeInput, CidadeOutput> {

    private ModelMapper modelMapper;

    @Override
    public Cidade toDomain(CidadeInput cidadeInput) {
        return modelMapper.map(cidadeInput, Cidade.class);
    }

    @Override
    public CidadeOutput toOutput(Cidade cidade) {
        return modelMapper.map(cidade, CidadeOutput.class);
    }

    @Override
    public List<Cidade> toDomainCollection(List<CidadeInput> cidadeInputs) {
        return cidadeInputs.stream()
                .map(dto -> toDomain(dto))
                .collect(Collectors.toList());
    }

    @Override
    public List<CidadeOutput> toOutputCollection(List<Cidade> cidades) {
        return cidades.stream()
                .map(entity -> toOutput(entity))
                .collect(Collectors.toList());
    }

    @Override
    public Page<CidadeOutput> toOutputCollection(Page<Cidade> cidades) {
        return new PageImpl<>(toOutputCollection(cidades.toList()));
    }

    @Override
    public void updateEntity(CidadeInput newEntity, Cidade currentEntity) {
        modelMapper.map(newEntity, currentEntity);
    }

}