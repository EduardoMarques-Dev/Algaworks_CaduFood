package com.algaworks.cadufood.api.model.output;

import com.algaworks.cadufood.api.model.input.util.IdInput;
import com.algaworks.cadufood.domain.model.Restaurante;
import com.algaworks.cadufood.core.generic.crud.GenericEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CozinhaOutput implements GenericEntity<CozinhaOutput> {

    private Long id;

    private String nome;

}
