package com.algaworks.cadufood.api.controller;


import com.algaworks.cadufood.api.model.input.UsuarioInput;
import com.algaworks.cadufood.api.model.resume.UsuarioSenha;
import com.algaworks.cadufood.api.model.resume.UsuarioUpdate;
import com.algaworks.cadufood.api.model.mapper.UsuarioMapper;
import com.algaworks.cadufood.api.model.output.UsuarioOutput;
import com.algaworks.cadufood.core.generic.crud.GenericController;
import com.algaworks.cadufood.domain.exception.NegocioException;
import com.algaworks.cadufood.domain.exception.SenhaIncorretaException;
import com.algaworks.cadufood.domain.exception.SubEntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.model.Usuario;
import com.algaworks.cadufood.domain.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

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

    @PutMapping("/{id}")
    public UsuarioOutput atualizar(@PathVariable Long id, @RequestBody @Valid UsuarioUpdate usuarioUpdate) {
        try {
            Usuario domainModel = usuarioService.buscar(id);
            mapper.updateEntity(usuarioUpdate, domainModel);
            return mapper.toOutput(usuarioService.recarregar(domainModel));
        } catch (DataIntegrityViolationException ex) {
            throw new SubEntidadeNaoEncontradaException();
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

    @Override
    @GetMapping
    public List<UsuarioOutput> listar() {
        return super.listar();
    }

    @Override
    @GetMapping("/{id}")
    public UsuarioOutput buscar(@PathVariable Long id) {
        return super.buscar(id);
    }

    @Override
    @PostMapping
    public UsuarioOutput salvar(@RequestBody @Valid UsuarioInput usuarioInput) {
        return super.salvar(usuarioInput);
    }

    @Override
    @DeleteMapping
    public void excluir(@PathVariable Long id) {
        super.excluir(id);
    }
}
