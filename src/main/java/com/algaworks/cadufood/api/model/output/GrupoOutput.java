package com.algaworks.cadufood.api.model.output;

import com.algaworks.cadufood.core.generic.model.DataTransferObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GrupoOutput implements DataTransferObject<GrupoOutput> {

    private Long id;

    private String nome;

//    private List<Permissao> permissoes;

}
