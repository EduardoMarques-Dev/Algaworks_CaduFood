package com.algaworks.cadufood.core.generic.crud;

public interface GenericEntity<DomainCLass> {

    Long getId();

    String getNome();

    default String getNomeField(){
     return "nome";
    }

}
