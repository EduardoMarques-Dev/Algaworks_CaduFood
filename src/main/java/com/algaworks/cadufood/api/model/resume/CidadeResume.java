package com.algaworks.cadufood.api.model.resume;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeResume {

    private Long id;

    private String nome;

    @JsonProperty("estado")
    private String nomeEstado;

}
