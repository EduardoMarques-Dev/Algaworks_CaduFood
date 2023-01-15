package com.algaworks.cadufood.api.model.output;

import com.algaworks.cadufood.core.generic.model.DataTransferObject;
import com.algaworks.cadufood.domain.model.Grupo;
import com.algaworks.cadufood.domain.model.Permissao;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GrupoOutput implements DataTransferObject<GrupoOutput> {

    private Long id;

    private String nome;

//    private List<Permissao> permissoes;

}
