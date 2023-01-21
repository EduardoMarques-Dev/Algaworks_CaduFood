package com.algaworks.cadufood.api.controller;


import com.algaworks.cadufood.api.model.input.UsuarioInput;
import com.algaworks.cadufood.api.model.mapper.UsuarioMapper;
import com.algaworks.cadufood.api.model.output.UsuarioOutput;
import com.algaworks.cadufood.api.model.resume.UsuarioSenha;
import com.algaworks.cadufood.api.model.resume.UsuarioUpdate;
import com.algaworks.cadufood.core.generic.crud.controller.ExceptPostPutController;
import com.algaworks.cadufood.domain.exception.NegocioException;
import com.algaworks.cadufood.domain.exception.SenhaIncorretaException;
import com.algaworks.cadufood.domain.model.Usuario;
import com.algaworks.cadufood.domain.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController extends ExceptPostPutController<Usuario, UsuarioInput, UsuarioOutput> {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioMapper mapper;

    public UsuarioController(UsuarioService service, UsuarioMapper mapper) {
        super(service, mapper);
    }

    @Override
    @PostMapping
    public UsuarioOutput salvar(@RequestBody @Valid UsuarioInput usuarioInput) {
        return super.salvar(usuarioInput);
    }

    @PutMapping("/{id}")
    public UsuarioOutput atualizar(@PathVariable Long id, @RequestBody @Valid UsuarioUpdate usuarioUpdate) {
        try {
            Usuario domainModel = usuarioService.buscar(id);
            mapper.updateEntity(usuarioUpdate, domainModel);
            return mapper.toOutput(usuarioService.recarregar(domainModel));
        } catch (DataIntegrityViolationException ex) {
            throw new NegocioException(ex);
        }
    }

    @PutMapping("/{id}/senha")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarSenha(@PathVariable Long id, @RequestBody @Valid UsuarioSenha usuarioSenha) {
            Usuario domainModel = usuarioService.buscar(id);
            if (domainModel.getSenha().equals(usuarioSenha.getSenhaAtual())){
                domainModel.setSenha(usuarioSenha.getNovaSenha());
            } else {
                throw new SenhaIncorretaException();
            }
    }

    @Override
    @PatchMapping("/{id}")
    public UsuarioOutput atualizarParcial(@PathVariable Long id, @RequestBody @Valid HashMap<String, Object> fields) {
        if(fields.containsKey("senha")){
            throw new NegocioException("Não é permitido atualizar a senha desta maneira");
        }
        return super.atualizarParcial(id, fields);
    }

}
