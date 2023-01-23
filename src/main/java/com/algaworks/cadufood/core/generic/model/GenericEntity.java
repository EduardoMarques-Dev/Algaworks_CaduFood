package com.algaworks.cadufood.core.generic.model;

import java.util.UUID;

public interface GenericEntity {

    Long getId();

    String getCodigo();

    void setCodigo(String codigo);

    String getNome();

    // Comentários: Para funcionar, é necessário sobrescrever e
    // anotar com @Prepersist
    default void gerarCodigo() {
        setCodigo(UUID.randomUUID().toString());
    }

}
