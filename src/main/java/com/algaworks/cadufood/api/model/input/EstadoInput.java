package com.algaworks.cadufood.api.model.input;

import com.algaworks.cadufood.core.generic.model.DTO;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoInput implements DTO {

    @NotBlank
    private String nome;

}
