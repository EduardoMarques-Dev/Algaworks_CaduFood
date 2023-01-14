package com.algaworks.cadufood.api.model.input;

import com.algaworks.cadufood.core.generic.crud.DataTransferEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoInput implements DataTransferEntity<EstadoInput> {

    @NotBlank
    private String nome;

}
