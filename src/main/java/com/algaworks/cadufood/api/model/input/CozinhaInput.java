package com.algaworks.cadufood.api.model.input;

import com.algaworks.cadufood.domain.model.util.GenericEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CozinhaInput implements GenericEntity<CozinhaInput> {

    @NotBlank
    private String nome;

}
