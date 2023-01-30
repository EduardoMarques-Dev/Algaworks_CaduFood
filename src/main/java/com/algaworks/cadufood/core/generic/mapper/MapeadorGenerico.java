package com.algaworks.cadufood.core.generic.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe que representa um mapeador REST genérico.
 *
 * Responsável por realizar conversões entre modelos
 * representacionais e de domínio.
 *
 * @author Carlos Eduardo Marques Pereira
 */
@RequiredArgsConstructor
public abstract class MapeadorGenerico<DomainModel, InputModel, OutputModel> {

    private final Class<DomainModel> domainClass;

    private final Class<InputModel> inputClass;

    private final Class<OutputModel> outputClass;

    protected final ModelMapper modelMapper = new ModelMapper();

    public DomainModel toDomain(InputModel inputModel) {
        return modelMapper.map(inputModel, domainClass);
    }

    public OutputModel toOutput(DomainModel domainModel) {
        return modelMapper.map(domainModel, outputClass);
    }

    public List<DomainModel> toDomainCollection(Collection<InputModel> inputModelList) {
        return inputModelList.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    public List<OutputModel> toOutputCollection(Collection<DomainModel> domainModelList) {
        return domainModelList.stream()
                .map(this::toOutput)
                .collect(Collectors.toList());
    }

    public Page<OutputModel> toOutputCollection(Page<DomainModel> domainModelPage) {
        return new PageImpl<>(toOutputCollection(domainModelPage.toList()));
    }

    public void updateEntity(InputModel newEntity, DomainModel currentEntity) {
        modelMapper.map(newEntity, currentEntity);
    }

    public void patchEntity(HashMap<String, Object> fields, DomainModel currentEntity) {
        modelMapper.map(fields, currentEntity);
    }

}
