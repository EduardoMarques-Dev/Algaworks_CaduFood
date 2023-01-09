package com.algaworks.cadufood.api.model.output;

import com.algaworks.cadufood.domain.model.Restaurante;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CozinhaOutput {

    private Long id;

    private String nome;

    private List<Restaurante> restaurantes = new ArrayList<>();

}
