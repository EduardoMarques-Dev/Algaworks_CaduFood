package com.algaworks.cadufood.api.model.input;

import com.algaworks.cadufood.domain.model.Cozinha;
import com.algaworks.cadufood.domain.model.Endereco;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class RestauranteInput {

    private String nome;

    private BigDecimal taxaFrete;

    private Endereco endereco;

    private Cozinha cozinha;

}
