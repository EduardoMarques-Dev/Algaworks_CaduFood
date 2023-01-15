package com.algaworks.cadufood.core.generic.model;

public interface GenericEntity<DomainCLass> {

    Long getId();

    String getNome();

    default String getNomeField(){
     return "nome";
    }

}
