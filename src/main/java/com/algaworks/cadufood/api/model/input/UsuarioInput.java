package com.algaworks.cadufood.api.model.input;

import com.algaworks.cadufood.core.generic.model.DataTransferObject;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioInput implements DataTransferObject<UsuarioInput> {

    @NotBlank
    private String nome;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String senha;

}
