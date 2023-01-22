package com.algaworks.cadufood.api.model.output;

import com.algaworks.cadufood.core.generic.model.DataTransferObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormaPagamentoOutput implements DataTransferObject<FormaPagamentoOutput> {

    private String codigo;

    private String descricao;

}
