package com.algaworks.cadufood.api.model.output;

import com.algaworks.cadufood.core.generic.crud.DTOEntity;
import com.algaworks.cadufood.core.generic.crud.GenericEntity;
import com.algaworks.cadufood.domain.model.Estado;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeOutput implements DTOEntity<CidadeOutput> {

    private Long id;

    private String nome;

    private Estado estado;

}