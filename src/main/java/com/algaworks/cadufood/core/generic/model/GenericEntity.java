package com.algaworks.cadufood.core.generic.model;

import java.util.UUID;

public interface GenericEntity<DomainCLass> {

    Long getId();

    String getCodigo();

    void setCodigo(String codigo);

    String getNome();

    default void gerarCodigo() {
        setCodigo(UUID.randomUUID().toString());
    }

//    Class<? extends GenericEntity> getEntityClass();

}
