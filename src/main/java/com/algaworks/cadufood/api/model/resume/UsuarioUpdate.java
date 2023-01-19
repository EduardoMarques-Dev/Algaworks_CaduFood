package com.algaworks.cadufood.api.model.resume;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioUpdate {

    @NotBlank
    private String nome;

    @Email
    @NotBlank
    private String email;

}
