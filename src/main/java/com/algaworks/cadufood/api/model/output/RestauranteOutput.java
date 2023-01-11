package com.algaworks.cadufood.api.model.output;

import com.algaworks.cadufood.domain.model.Endereco;
import com.algaworks.cadufood.domain.model.FormaPagamento;
import com.algaworks.cadufood.domain.model.Produto;
import com.algaworks.cadufood.domain.model.util.GenericEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class RestauranteOutput implements GenericEntity<RestauranteOutput> {

    private Long id;

    private String nome;

    private BigDecimal taxaFrete;

    private LocalDateTime dataCadastro;

    private LocalDateTime dataAtualizacao;

    private Endereco endereco;

    private CozinhaOutput cozinha;

    private List<Produto> produto;

    private List<FormaPagamento> formasPagamento;

}
