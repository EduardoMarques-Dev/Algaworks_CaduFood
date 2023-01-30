package com.algaworks.cadufood.api.model.output;

import com.algaworks.cadufood.core.generic.model.DTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoOutput implements DTO {

    private String codigo;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Boolean ativo;

}