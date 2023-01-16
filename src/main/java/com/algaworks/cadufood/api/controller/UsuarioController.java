package com.algaworks.cadufood.api.controller;


import com.algaworks.cadufood.api.model.input.UsuarioInput;
import com.algaworks.cadufood.api.model.mapper.UsuarioMapper;
import com.algaworks.cadufood.api.model.output.UsuarioOutput;
import com.algaworks.cadufood.core.generic.crud.GenericController;
import com.algaworks.cadufood.domain.model.Usuario;
import com.algaworks.cadufood.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController extends GenericController<Usuario, UsuarioInput, UsuarioOutput> {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioMapper mapper;

    public UsuarioController(UsuarioService service, UsuarioMapper mapper) {
        super(service, mapper);
    }
}
