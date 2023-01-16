package com.algaworks.cadufood.api.model.input;

import com.algaworks.cadufood.api.model.resume.IdResume;
import com.algaworks.cadufood.core.generic.model.DataTransferObject;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeInput implements DataTransferObject<CidadeInput> {

    @NotBlank
    private String nome;

    @NotNull
    private IdResume estado;

}