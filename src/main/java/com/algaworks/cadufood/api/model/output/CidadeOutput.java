package com.algaworks.cadufood.api.model.output;

import com.algaworks.cadufood.core.generic.model.DTO;
import lombok.Getter;
import lombok.Setter;

//@JsonFilter("CidadeOutput")
@Getter
@Setter
public class CidadeOutput implements DTO {

    private String codigo;

    private String nome;

    private EstadoOutput estado;

}