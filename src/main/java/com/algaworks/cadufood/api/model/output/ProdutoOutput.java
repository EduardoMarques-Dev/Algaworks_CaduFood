package com.algaworks.cadufood.api.model.output;

import com.algaworks.cadufood.core.generic.model.DataTransferObject;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoOutput implements DataTransferObject {

    private String codigo;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Boolean ativo;

}