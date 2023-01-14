package com.algaworks.cadufood.api.model.output;

import com.algaworks.cadufood.core.generic.crud.DTOEntity;
import com.algaworks.cadufood.core.generic.crud.GenericEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CozinhaOutput implements DTOEntity<CozinhaOutput> {

    private Long id;

    private String nome;

}
