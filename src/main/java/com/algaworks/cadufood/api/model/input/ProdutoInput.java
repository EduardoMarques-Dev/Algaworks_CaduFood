package com.algaworks.cadufood.api.model.input;

import com.algaworks.cadufood.core.generic.model.DTO;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoInput implements DTO {

    @NotBlank
    private String nome;
    private String descricao;
    @NotNull
    @Min(1)
    private BigDecimal preco;

}
