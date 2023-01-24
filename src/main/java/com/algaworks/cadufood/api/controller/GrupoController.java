package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.api.model.input.GrupoInput;
import com.algaworks.cadufood.api.model.output.GrupoOutput;
import com.algaworks.cadufood.core.generic.crud.controller.BasicController;
import com.algaworks.cadufood.domain.model.Grupo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/grupos")
public class GrupoController extends BasicController<Grupo, GrupoInput, GrupoOutput> {

}
