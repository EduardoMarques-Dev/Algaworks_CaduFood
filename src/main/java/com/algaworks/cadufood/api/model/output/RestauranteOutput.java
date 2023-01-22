package com.algaworks.cadufood.api.model.output;

import com.algaworks.cadufood.core.generic.model.DataTransferObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class RestauranteOutput implements DataTransferObject {

    private String codigo;

    private String nome;

    private Boolean ativo;

    private BigDecimal taxaFrete;

    private LocalDateTime dataCadastro;

    private LocalDateTime dataAtualizacao;

    private EnderecoOutput endereco;

    @JsonProperty("cozinha")
    private String nomeCozinha;

//    private List<Produto> produto;

    private List<FormaPagamentoOutput> formasPagamento;

}
