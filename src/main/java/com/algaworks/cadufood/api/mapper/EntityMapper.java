package com.algaworks.cadufood.api.mapper;

import org.springframework.data.domain.Page;

import java.util.List;

public interface EntityMapper<DomainModel, InputModel, OutputModel> {

    DomainModel toDomain(InputModel inputModel);

    OutputModel toOutput(DomainModel domainModel);

    List<DomainModel> toDomainCollection(List<InputModel> inputModelList);

    List<OutputModel> toOutputCollection(List<DomainModel> domainModelList);

    Page<OutputModel> toOutputCollection(Page<DomainModel> domainModelPage);

    void updateEntity(InputModel newEntity, DomainModel currentEntity);

}
