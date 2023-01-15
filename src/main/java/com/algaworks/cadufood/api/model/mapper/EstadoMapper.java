package com.algaworks.cadufood.api.model.mapper;

import com.algaworks.cadufood.api.model.input.EstadoInput;
import com.algaworks.cadufood.api.model.output.EstadoOutput;
import com.algaworks.cadufood.core.generic.mapper.GenericMapper;
import com.algaworks.cadufood.domain.model.Estado;
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
public class EstadoMapper implements GenericMapper<Estado, EstadoInput, EstadoOutput> {

    private ModelMapper modelMapper;

    @Override
    public Estado toDomain(EstadoInput estadoInput) {
        return modelMapper.map(estadoInput, Estado.class);
    }

    @Override
    public EstadoOutput toOutput(Estado estado) {
        return modelMapper.map(estado, EstadoOutput.class);
    }

    @Override
    public List<Estado> toDomainCollection(List<EstadoInput> estadoInputs) {
        return estadoInputs.stream()
                .map(dto -> toDomain(dto))
                .collect(Collectors.toList());
    }

    @Override
    public List<EstadoOutput> toOutputCollection(List<Estado> estados) {
        return estados.stream()
                .map(entity -> toOutput(entity))
                .collect(Collectors.toList());
    }

    @Override
    public Page<EstadoOutput> toOutputCollection(Page<Estado> estados) {
        return new PageImpl<>(toOutputCollection(estados.toList()));
    }

    @Override
    public void updateEntity(EstadoInput newEntity, Estado currentEntity) {
        modelMapper.map(newEntity, currentEntity);
    }

    @Override
    public void patchEntity(HashMap<String, Object> fields, Estado currentEntity) {
        modelMapper.map(fields, currentEntity);
    }

}
