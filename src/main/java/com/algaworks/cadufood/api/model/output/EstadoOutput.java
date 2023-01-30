package com.algaworks.cadufood.api.model.output;

import com.algaworks.cadufood.core.generic.model.DTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoOutput implements DTO {

    private String codigo;

    private String nome;

}
