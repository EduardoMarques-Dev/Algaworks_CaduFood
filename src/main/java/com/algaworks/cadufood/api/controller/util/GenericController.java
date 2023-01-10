package com.algaworks.cadufood.api.controller.util;

import com.algaworks.cadufood.api.mapper.util.GenericMapper;
import com.algaworks.cadufood.domain.model.util.GenericEntity;
import com.algaworks.cadufood.domain.service.util.GenericService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
public abstract class GenericController<
        DomainModel extends GenericEntity<DomainModel>,
        InputModel extends  GenericEntity<InputModel>,
        OutputModel extends GenericEntity<OutputModel>> {

    private final GenericService<DomainModel> service;

    private final GenericMapper<DomainModel,InputModel,OutputModel> mapper;

    @GetMapping
    public List<OutputModel> listar(){
        return mapper.toOutputCollection(service.listar());
    }

    @GetMapping("/{id}")
    public OutputModel buscar(@PathVariable Long id){
        DomainModel domainModel = service.buscar(id);
        return mapper.toOutput(domainModel);
    }

    @GetMapping("/buscar-primeiro")
    public OutputModel buscarPrimeiro() {
        DomainModel domainModel = service.buscarPrimeiro();
        return mapper.toOutput(domainModel);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OutputModel salvar(@RequestBody InputModel inputModel){
        DomainModel domainModel = mapper.toDomain(inputModel);
        domainModel = service.salvar(domainModel);
        return mapper.toOutput(domainModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        service.excluir(id);
    }
}
