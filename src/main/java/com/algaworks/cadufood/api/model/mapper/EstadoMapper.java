package com.algaworks.cadufood.api.model.mapper;

import com.algaworks.cadufood.api.model.input.EstadoInput;
import com.algaworks.cadufood.api.model.output.EstadoOutput;
import com.algaworks.cadufood.core.generic.mapper.MapeadorGenerico;
import com.algaworks.cadufood.domain.model.Estado;
import org.springframework.stereotype.Component;


@Component
public class EstadoMapper extends MapeadorGenerico<Estado, EstadoInput, EstadoOutput> {

    public EstadoMapper() {
        super(Estado.class, EstadoInput.class, EstadoOutput.class);
    }

}
