package com.algaworks.cadufood.api.model.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioSenha {

    @NotBlank
    private String senhaAtual;

    @NotBlank
    private String novaSenha;

}
