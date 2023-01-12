package com.algaworks.cadufood.core.generic.crud;

import com.algaworks.cadufood.core.generic.mapper.GenericMapper;
import com.algaworks.cadufood.domain.exception.NegocioException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
public abstract class GenericController<
        DomainModel extends GenericEntity<DomainModel>,
        InputModel extends GenericEntity<InputModel>,
        OutputModel extends GenericEntity<OutputModel>> {

    private final GenericService<DomainModel> service;

    private final GenericMapper<DomainModel, InputModel, OutputModel> mapper;

    @GetMapping
    public List<OutputModel> listar() {
        return mapper.toOutputCollection(service.listar());
    }

    @GetMapping("/{id}")
    public OutputModel buscar(@PathVariable Long id) {
        DomainModel domainModel = service.buscar(id);
        return mapper.toOutput(domainModel);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OutputModel salvar(@RequestBody @Valid InputModel inputModel) {
        DomainModel domainModel = mapper.toDomain(inputModel);
        domainModel = service.salvar(domainModel);
        return mapper.toOutput(domainModel);
    }

    @Transactional
    @PutMapping("/{id}")
    public OutputModel atualizar(@PathVariable Long id,
                                 @RequestBody @Valid InputModel inputModel) {
        try {
            DomainModel domainModel = service.buscar(id);
            mapper.updateEntity(inputModel, domainModel);
            return mapper.toOutput(service.recarregar(domainModel));
        } catch (DataIntegrityViolationException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    @Transactional
    @PatchMapping("/{id}")
    public OutputModel atualizarParcial(@PathVariable Long id,
                                        @RequestBody HashMap<String,Object> fields) {
        try {
            DomainModel domainModel = service.buscar(id);
            mapper.patchEntity(fields, domainModel);
            return mapper.toOutput(service.recarregar(domainModel));
        } catch (DataIntegrityViolationException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
