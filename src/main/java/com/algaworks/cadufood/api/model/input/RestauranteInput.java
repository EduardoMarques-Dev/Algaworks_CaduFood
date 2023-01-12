package com.algaworks.cadufood.api.model.input;

import com.algaworks.cadufood.api.model.input.util.IdInput;
import com.algaworks.cadufood.domain.model.Endereco;
import com.algaworks.cadufood.core.generic.crud.GenericEntity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class RestauranteInput implements GenericEntity<RestauranteInput> {

    @NotBlank
    private String nome;

    @PositiveOrZero
    private BigDecimal taxaFrete;

    @NotNull
    private Endereco endereco;

    @NotNull
    @Valid
    private IdInput cozinha;

}
