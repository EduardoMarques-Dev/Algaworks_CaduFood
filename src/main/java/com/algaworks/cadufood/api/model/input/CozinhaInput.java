package com.algaworks.cadufood.api.model.input;

import com.algaworks.cadufood.core.generic.crud.DTOEntity;
import com.algaworks.cadufood.core.generic.crud.GenericEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CozinhaInput implements DTOEntity<CozinhaInput> {

    @NotBlank
    private String nome;

}
