package com.algaworks.cadufood.api.model.mapper;

import com.algaworks.cadufood.api.model.input.GrupoInput;
import com.algaworks.cadufood.api.model.output.GrupoOutput;
import com.algaworks.cadufood.core.generic.mapper.GenericMapper;
import com.algaworks.cadufood.domain.model.Grupo;
import org.springframework.stereotype.Component;

@Component
public class GrupoMapper extends GenericMapper<Grupo, GrupoInput, GrupoOutput> {

    public GrupoMapper() {
        super(Grupo.class, GrupoInput.class, GrupoOutput.class);
    }

}
