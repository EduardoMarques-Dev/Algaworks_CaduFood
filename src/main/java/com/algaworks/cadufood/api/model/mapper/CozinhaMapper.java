package com.algaworks.cadufood.api.model.mapper;

import com.algaworks.cadufood.api.model.input.CozinhaInput;
import com.algaworks.cadufood.api.model.output.CozinhaOutput;
import com.algaworks.cadufood.core.generic.mapper.MapeadorGenerico;
import com.algaworks.cadufood.domain.model.Cozinha;
import org.springframework.stereotype.Component;


@Component
public class CozinhaMapper extends MapeadorGenerico<Cozinha, CozinhaInput, CozinhaOutput> {

    public CozinhaMapper() {
        super(Cozinha.class, CozinhaInput.class, CozinhaOutput.class);
    }

}
