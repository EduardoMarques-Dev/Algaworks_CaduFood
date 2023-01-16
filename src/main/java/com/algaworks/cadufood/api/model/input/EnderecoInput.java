package com.algaworks.cadufood.api.model.input;

import com.algaworks.cadufood.api.model.resume.IdResume;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoInput {

    @NotBlank
    private String cep;

    @NotBlank
    private String logradouro;

    @NotBlank
    private String numero;

    @NotBlank
    private String bairro;

    @Valid
    @NotNull
    private IdResume cidade;

}
