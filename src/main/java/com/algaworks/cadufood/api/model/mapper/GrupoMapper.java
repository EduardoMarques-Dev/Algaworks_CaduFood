package com.algaworks.cadufood.api.model.mapper;

import com.algaworks.cadufood.api.model.input.GrupoInput;
import com.algaworks.cadufood.api.model.output.GrupoOutput;
import com.algaworks.cadufood.core.generic.mapper.GenericMapper;
import com.algaworks.cadufood.domain.model.Grupo;
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
public class GrupoMapper implements GenericMapper<Grupo, GrupoInput, GrupoOutput> {

    private ModelMapper modelMapper;

    @Override
    public Grupo toDomain(GrupoInput grupoInput) {
        return modelMapper.map(grupoInput, Grupo.class);
    }

    @Override
    public GrupoOutput toOutput(Grupo grupo) {
        return modelMapper.map(grupo, GrupoOutput.class);
    }

    @Override
    public List<Grupo> toDomainCollection(List<GrupoInput> grupoInputs) {
        return grupoInputs.stream()
                .map(dto -> toDomain(dto))
                .collect(Collectors.toList());
    }

    @Override
    public List<GrupoOutput> toOutputCollection(List<Grupo> grupos) {
        return grupos.stream()
                .map(entity -> toOutput(entity))
                .collect(Collectors.toList());
    }

    @Override
    public Page<GrupoOutput> toOutputCollection(Page<Grupo> grupos) {
        return new PageImpl<>(toOutputCollection(grupos.toList()));
    }

    @Override
    public void updateEntity(GrupoInput newEntity, Grupo currentEntity) {
        modelMapper.map(newEntity, currentEntity);
    }

    @Override
    public void patchEntity(HashMap<String, Object> fields, Grupo currentEntity) {
        modelMapper.map(fields, currentEntity);
    }
    
}
