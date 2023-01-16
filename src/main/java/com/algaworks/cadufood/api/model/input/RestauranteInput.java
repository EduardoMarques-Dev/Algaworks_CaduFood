package com.algaworks.cadufood.api.model.input;

import com.algaworks.cadufood.api.model.input.util.IdInput;
import com.algaworks.cadufood.core.generic.model.DataTransferObject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class RestauranteInput implements DataTransferObject<RestauranteInput> {

    @NotBlank
    private String nome;

//    @NotNull
//    private Boolean ativo;

    @PositiveOrZero
    private BigDecimal taxaFrete;

    @NotNull
    @Valid
    private EnderecoInput endereco;

    @NotNull
    @Valid
    private IdInput cozinha;

}
