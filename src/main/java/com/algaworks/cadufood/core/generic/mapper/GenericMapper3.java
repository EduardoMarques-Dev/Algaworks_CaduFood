//package com.algaworks.cadufood.core.generic.mapper;
//
//import org.springframework.data.domain.Page;
//
//import java.util.HashMap;
//import java.util.List;
//
//public interface GenericMapper<DomainModel, InputModel, OutputModel> {
//
//    DomainModel toDomain(InputModel inputModel);
//
//    OutputModel toOutput(DomainModel domainModel);
//
//    List<DomainModel> toDomainCollection(List<InputModel> inputModelList);
//
//    List<OutputModel> toOutputCollection(List<DomainModel> domainModelList);
//
//    Page<OutputModel> toOutputCollection(Page<DomainModel> domainModelPage);
//
//    void updateEntity(InputModel newEntity, DomainModel currentEntity);
//
//    void patchEntity(HashMap<String, Object> fields, DomainModel currentEntity);
//
//}
