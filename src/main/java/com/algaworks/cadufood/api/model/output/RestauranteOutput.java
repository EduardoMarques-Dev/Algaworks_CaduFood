package com.algaworks.cadufood.api.model.output;

import com.algaworks.cadufood.domain.model.util.GenericEntity;
import com.algaworks.cadufood.domain.model.*;
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

    private Cozinha cozinha;

    private List<Produto> produto;

    private List<FormaPagamento> formasPagamento;

    @Override
    public void update(RestauranteOutput source) {
        this.nome = source.getNome();
        this.taxaFrete = source.getTaxaFrete();
        this.dataCadastro = source.getDataCadastro();
        this.dataAtualizacao = source.getDataAtualizacao();
        this.endereco = source.getEndereco();
        this.cozinha = source.getCozinha();
        this.produto = source.getProduto();
        this.formasPagamento = source.getFormasPagamento();
    }

    @Override
    public RestauranteOutput createNewInstance() {
        RestauranteOutput newInstance = new RestauranteOutput();
        newInstance.update(this);
        return newInstance;
    }
}
