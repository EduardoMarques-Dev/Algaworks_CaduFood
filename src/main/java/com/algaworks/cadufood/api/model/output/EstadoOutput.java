package com.algaworks.cadufood.api.model.output;

import com.algaworks.cadufood.domain.model.util.GenericEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoOutput implements GenericEntity<EstadoOutput> {

    private Long id;

    private String nome;

}
