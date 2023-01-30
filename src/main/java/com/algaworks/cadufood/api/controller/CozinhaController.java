package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.api.model.input.CozinhaInput;
import com.algaworks.cadufood.api.model.output.CozinhaOutput;
import com.algaworks.cadufood.core.generic.crud.controller.ControladorBasico;
import com.algaworks.cadufood.domain.model.Cozinha;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cozinhas")
public class CozinhaController extends ControladorBasico<Cozinha, CozinhaInput, CozinhaOutput> {

}
