package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.api.model.input.GrupoInput;
import com.algaworks.cadufood.api.model.mapper.GrupoMapper;
import com.algaworks.cadufood.api.model.output.GrupoOutput;
import com.algaworks.cadufood.core.generic.crud.controller.ControladorBasico;
import com.algaworks.cadufood.core.generic.crud.service.ServicoGenerico;
import com.algaworks.cadufood.core.generic.mapper.MapeadorGenerico;
import com.algaworks.cadufood.domain.model.Grupo;
import com.algaworks.cadufood.domain.service.GrupoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/grupos")
public class GrupoController extends ControladorBasico<Grupo, GrupoInput, GrupoOutput> {

    public GrupoController(GrupoService servico, GrupoMapper mapper) {
        super(servico, mapper);
    }
}
