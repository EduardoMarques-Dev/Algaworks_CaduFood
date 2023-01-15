package com.algaworks.cadufood.api.model.input;

import com.algaworks.cadufood.api.model.input.util.IdInput;
import com.algaworks.cadufood.core.generic.model.DataTransferObject;
import com.algaworks.cadufood.domain.model.Endereco;
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

    private Boolean ativo;

    @PositiveOrZero
    private BigDecimal taxaFrete;

    @NotNull
    private Endereco endereco;

    @NotNull
    @Valid
    private IdInput cozinha;

}
