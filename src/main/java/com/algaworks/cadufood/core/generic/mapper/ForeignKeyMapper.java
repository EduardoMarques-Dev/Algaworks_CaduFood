package com.algaworks.cadufood.core.generic.mapper;

// Utilizado quando a classe possui Foreign Keys
// Que precisam ser limpadas para a atualização de recurso
public interface ForeignKeyMapper<DomainModel, InputModel, OutputModel> extends GenericMapper<DomainModel, InputModel, OutputModel> {

    void eraseForeignKey(DomainModel domainModel);

}
