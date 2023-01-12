package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.core.generic.crud.GenericController;
import com.algaworks.cadufood.api.mapper.EstadoMapper;
import com.algaworks.cadufood.api.model.input.EstadoInput;
import com.algaworks.cadufood.api.model.output.EstadoOutput;
import com.algaworks.cadufood.domain.model.Estado;
import com.algaworks.cadufood.domain.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estados")
public class EstadoController extends GenericController<Estado, EstadoInput, EstadoOutput> {

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private EstadoMapper mapper;

    public EstadoController(EstadoService service, EstadoMapper mapper) {
        super(service, mapper);
    }

}
