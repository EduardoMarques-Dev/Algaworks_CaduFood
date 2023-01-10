package com.algaworks.cadufood.api.model.input;

import com.algaworks.cadufood.domain.model.util.GenericEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoInput implements GenericEntity<EstadoInput> {

    private String nome;

}
