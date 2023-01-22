package com.algaworks.cadufood.api.model.output;

import com.algaworks.cadufood.core.generic.model.DataTransferObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CozinhaOutput implements DataTransferObject<CozinhaOutput> {

    private String codigo;

    private String nome;

}
