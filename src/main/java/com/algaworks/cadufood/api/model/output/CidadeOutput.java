package com.algaworks.cadufood.api.model.output;

import com.algaworks.cadufood.core.generic.crud.DataTransferEntity;
import com.algaworks.cadufood.domain.model.Estado;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeOutput implements DataTransferEntity<CidadeOutput> {

    private Long id;

    private String nome;

    private Estado estado;

}