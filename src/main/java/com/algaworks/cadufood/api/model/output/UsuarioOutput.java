package com.algaworks.cadufood.api.model.output;

import com.algaworks.cadufood.core.generic.model.DataTransferObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioOutput implements DataTransferObject<UsuarioOutput> {

    private String codigo;

    private String nome;

    private String email;

}
