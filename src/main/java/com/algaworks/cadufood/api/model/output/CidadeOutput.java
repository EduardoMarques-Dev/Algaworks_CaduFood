package com.algaworks.cadufood.api.model.output;

import com.algaworks.cadufood.core.generic.model.DataTransferObject;
import com.algaworks.cadufood.domain.model.Estado;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeOutput implements DataTransferObject<CidadeOutput> {

    private Long id;

    private String nome;

    private EstadoOutput estado;

}