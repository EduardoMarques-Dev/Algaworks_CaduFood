package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.api.model.input.EstadoInput;
import com.algaworks.cadufood.api.model.output.EstadoOutput;
import com.algaworks.cadufood.core.generic.crud.controller.ControladorBasico;
import com.algaworks.cadufood.domain.model.Estado;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estados")
public class EstadoController extends ControladorBasico<Estado, EstadoInput, EstadoOutput> {

}
