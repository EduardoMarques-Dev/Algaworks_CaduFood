package com.algaworks.cadufood.api.model.input;

import com.algaworks.cadufood.api.model.input.util.IdInput;
import com.algaworks.cadufood.core.generic.crud.DataTransferEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeInput implements DataTransferEntity<CidadeInput> {

    @NotBlank
    private String nome;

    @NotNull
    private IdInput estado;

}