package com.algaworks.cadufood.core.generic.crud;

import com.algaworks.cadufood.domain.exception.NegocioException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/buscar-primeiro")
    public OutputModel buscarPrimeiro() {
        DomainModel domainModel = service.buscarPrimeiro();
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
        DomainModel domainModel = service.buscar(id);
        mapper.updateEntity(inputModel, domainModel);

        try {
            return mapper.toOutput(service.salvar(domainModel));
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
