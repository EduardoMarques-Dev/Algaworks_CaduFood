package com.algaworks.cadufood.api.model.input;

import com.algaworks.cadufood.domain.model.Estado;
import com.algaworks.cadufood.domain.model.util.GenericEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeInput implements GenericEntity<CidadeInput> {

    private String nome;

    private Estado estado;

}