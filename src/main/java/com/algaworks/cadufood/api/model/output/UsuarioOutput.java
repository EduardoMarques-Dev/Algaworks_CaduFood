package com.algaworks.cadufood.api.model.output;

import com.algaworks.cadufood.core.generic.model.DataTransferObject;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class UsuarioOutput implements DataTransferObject<UsuarioOutput> {

    private Long id;

    private String nome;

    private String email;

    private String senha;

    private LocalDateTime dataCadastro;

    private List<GrupoOutput> grupos;

}
