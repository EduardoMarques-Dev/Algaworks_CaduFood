package com.algaworks.cadufood.api.model.input;

import com.algaworks.cadufood.domain.model.Cozinha;
import com.algaworks.cadufood.domain.model.Endereco;
import com.algaworks.cadufood.domain.model.util.GenericEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class RestauranteInput implements GenericEntity<RestauranteInput> {

    private String nome;

    private BigDecimal taxaFrete;

    private Endereco endereco;

    private Cozinha cozinha;

    @Override
    public void update(RestauranteInput source) {
        this.nome = source.getNome();
        this.taxaFrete = source.getTaxaFrete();
        this.endereco = source.getEndereco();
        this.cozinha = source.getCozinha();
    }

    @Override
    public RestauranteInput createNewInstance() {
        RestauranteInput newInstance = new RestauranteInput();
        newInstance.update(this);
        return newInstance;
    }
}
