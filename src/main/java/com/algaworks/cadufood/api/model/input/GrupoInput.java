package com.algaworks.cadufood.api.model.input;

import com.algaworks.cadufood.core.generic.model.DataTransferObject;
import com.algaworks.cadufood.domain.model.Grupo;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GrupoInput implements DataTransferObject<GrupoInput> {

    @NotBlank
    private String nome;

}
