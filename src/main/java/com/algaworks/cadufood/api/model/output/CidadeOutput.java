package com.algaworks.cadufood.api.model.output;

import com.algaworks.cadufood.domain.model.Estado;
import com.algaworks.cadufood.domain.model.util.GenericEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeOutput implements GenericEntity<CidadeOutput> {

    private Long id;

    private String nome;

    private Estado estado;

}