package com.algaworks.cadufood.api.model.input;

import com.algaworks.cadufood.domain.model.util.GenericEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CozinhaInput implements GenericEntity<CozinhaInput> {

    private String nome;

}
