package com.algaworks.cadufood.core.generic.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public abstract class GenericMapper<DomainModel, InputModel, OutputModel> {

    private final Class<DomainModel> domainClass;

    private final Class<InputModel> inputClass;

    private final Class<OutputModel> outputClass;

    protected final ModelMapper modelMapper = new ModelMapper();

    public DomainModel toDomain(InputModel cidadeInput) {
        return modelMapper.map(cidadeInput, domainClass);
    }

    public OutputModel toOutput(DomainModel cidade) {
        return modelMapper.map(cidade, outputClass);
    }

    public List<DomainModel> toDomainCollection(List<InputModel> cidadeInputs) {
        return cidadeInputs.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    public List<OutputModel> toOutputCollection(List<DomainModel> cidades) {
        return cidades.stream()
                .map(this::toOutput)
                .collect(Collectors.toList());
    }

    public Page<OutputModel> toOutputCollection(Page<DomainModel> cidades) {
        return new PageImpl<>(toOutputCollection(cidades.toList()));
    }

    public void updateEntity(InputModel newEntity, DomainModel currentEntity) {
        modelMapper.map(newEntity, currentEntity);
    }

    public void patchEntity(HashMap<String, Object> fields, DomainModel currentEntity) {
        modelMapper.map(fields, currentEntity);
    }

}
