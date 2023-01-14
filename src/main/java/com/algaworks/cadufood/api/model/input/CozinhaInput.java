package com.algaworks.cadufood.api.model.input;

import com.algaworks.cadufood.core.generic.crud.DataTransferEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CozinhaInput implements DataTransferEntity<CozinhaInput> {

    @NotBlank
    private String nome;

}
