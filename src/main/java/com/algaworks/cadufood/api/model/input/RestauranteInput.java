package com.algaworks.cadufood.api.model.input;

import com.algaworks.cadufood.api.model.resume.IdResume;
import com.algaworks.cadufood.core.generic.model.DTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class RestauranteInput implements DTO {

    @NotBlank
    private String nome;

    @PositiveOrZero
    private BigDecimal taxaFrete;

    @NotNull
    @Valid
    private EnderecoInput endereco;

    @NotNull
    @Valid
    private IdResume cozinha;

}
