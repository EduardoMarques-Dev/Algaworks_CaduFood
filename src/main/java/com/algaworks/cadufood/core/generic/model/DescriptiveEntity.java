package com.algaworks.cadufood.core.generic.model;

public interface DescriptiveEntity<DomainClass> extends GenericEntity<DomainClass> {

    String getDescricao();

    @Override
    default String getNome(){
        return getDescricao();
    }

    @Override
    default String getNomeField() {
        return "descricao";
    }
}
