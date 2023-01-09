package com.algaworks.cadufood.api.model.input;

import com.algaworks.cadufood.domain.model.Cozinha;
import com.algaworks.cadufood.domain.model.Endereco;
import com.algaworks.cadufood.domain.model.Restaurante;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RestauranteInput {

    private String nome;

    private BigDecimal taxaFrete;

    private Endereco endereco;

    private Cozinha cozinha;

}
