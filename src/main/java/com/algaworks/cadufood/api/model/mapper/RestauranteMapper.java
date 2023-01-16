package com.algaworks.cadufood.api.model.mapper;

import com.algaworks.cadufood.api.model.input.RestauranteInput;
import com.algaworks.cadufood.api.model.output.RestauranteOutput;
import com.algaworks.cadufood.core.generic.mapper.DetachedKeyMapper;
import com.algaworks.cadufood.domain.model.Cidade;
import com.algaworks.cadufood.domain.model.Cozinha;
import com.algaworks.cadufood.domain.model.Restaurante;
import org.springframework.stereotype.Component;


@Component
public class RestauranteMapper extends DetachedKeyMapper<Restaurante, RestauranteInput, RestauranteOutput> {

    public RestauranteMapper() {
        super(Restaurante.class, RestauranteInput.class, RestauranteOutput.class);
    }

    @Override
    public void detachForeignKey(Restaurante restaurante) {
        Long cozinhaId = restaurante.getCozinha().getId();
        restaurante.setCozinha(new Cozinha());
        restaurante.getCozinha().setId(cozinhaId);

        if (restaurante.getEndereco() != null
                && restaurante.getEndereco().getCidade() != null){
            Long cidadeId = restaurante.getEndereco().getCidade().getId();
            restaurante.getEndereco().setCidade(new Cidade());
            restaurante.getEndereco().getCidade().setId(cidadeId);
        }
    }

}
