package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.api.model.input.EstadoInput;
import com.algaworks.cadufood.api.model.mapper.EstadoMapper;
import com.algaworks.cadufood.api.model.output.EstadoOutput;
import com.algaworks.cadufood.core.generic.crud.controller.ControladorBasico;
import com.algaworks.cadufood.domain.model.Estado;
import com.algaworks.cadufood.domain.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estados")
public class EstadoController extends ControladorBasico<Estado, EstadoInput, EstadoOutput> {

    @Autowired
    public EstadoController(EstadoService servico, EstadoMapper mapper) {
        super(servico, mapper);
    }
}