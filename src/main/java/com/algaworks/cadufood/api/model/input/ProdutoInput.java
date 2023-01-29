package com.algaworks.cadufood.api.model.input;

import com.algaworks.cadufood.api.model.resume.IdResume;
import com.algaworks.cadufood.core.generic.model.DataTransferObject;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoInput implements DataTransferObject {

    @NotBlank
    private String nome;
    private String descricao;
    @NotNull
    @Min(1)
    private BigDecimal preco;
    @NotNull
    private IdResume restaurante;

}
