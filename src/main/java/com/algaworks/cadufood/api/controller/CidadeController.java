package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.core.generic.crud.GenericController;
import com.algaworks.cadufood.api.mapper.CidadeMapper;
import com.algaworks.cadufood.api.model.input.CidadeInput;
import com.algaworks.cadufood.api.model.output.CidadeOutput;
import com.algaworks.cadufood.domain.model.Cidade;
import com.algaworks.cadufood.domain.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController extends GenericController<Cidade, CidadeInput, CidadeOutput> {

    @Autowired
    private CidadeService cidadeService;

    @Autowired
    private CidadeMapper mapper;

    public CidadeController(CidadeService service, CidadeMapper mapper) {
        super(service, mapper);
    }

}
