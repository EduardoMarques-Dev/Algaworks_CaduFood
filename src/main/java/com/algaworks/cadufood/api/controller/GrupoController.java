package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.api.model.input.GrupoInput;
import com.algaworks.cadufood.api.model.mapper.GrupoMapper;
import com.algaworks.cadufood.api.model.output.GrupoOutput;
import com.algaworks.cadufood.core.generic.crud.GenericController;
import com.algaworks.cadufood.domain.model.Grupo;
import com.algaworks.cadufood.domain.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/grupos")
public class GrupoController extends GenericController<Grupo, GrupoInput, GrupoOutput> {

    @Autowired
    private GrupoService grupoService;

    @Autowired
    private GrupoMapper mapper;


    public GrupoController(GrupoService service, GrupoMapper mapper) {
        super(service, mapper);
    }
}
