package com.algaworks.cadufood.api.model.input;

import com.algaworks.cadufood.api.model.resume.IdResume;
import com.algaworks.cadufood.core.generic.model.DTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeInput implements DTO {

    @NotBlank
    private String nome;

    @NotNull
    private IdResume estado;

}