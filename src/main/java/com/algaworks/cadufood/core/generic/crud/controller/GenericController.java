package com.algaworks.cadufood.core.generic.crud.controller;

import com.algaworks.cadufood.core.generic.crud.service.GenericService;
import com.algaworks.cadufood.core.generic.mapper.GenericMapper;
import com.algaworks.cadufood.core.generic.model.DataTransferObject;
import com.algaworks.cadufood.core.generic.model.GenericEntity;
import com.algaworks.cadufood.domain.exception.NegocioException;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
public abstract class GenericController<
        DomainModel extends GenericEntity<DomainModel>,
        InputModel extends DataTransferObject<InputModel>,
        OutputModel extends DataTransferObject<OutputModel>> {

    private final GenericService<DomainModel> service;

    private final GenericMapper<DomainModel, InputModel, OutputModel> mapper;

    public List<OutputModel> listar() {
        return mapper.toOutputCollection(service.listar());
    }

    public OutputModel buscar(Long id) {
        DomainModel domainModel = service.buscar(id);
        return mapper.toOutput(domainModel);
    }

    @ResponseStatus(HttpStatus.CREATED)
    public OutputModel salvar(InputModel inputModel) {
        DomainModel domainModel = mapper.toDomain(inputModel);
        domainModel = service.salvar(domainModel);
        return mapper.toOutput(domainModel);
    }

    @Transactional
    public OutputModel atualizar(Long id,
                                 InputModel inputModel) {
        try {
            DomainModel domainModel = service.buscar(id);
            mapper.updateEntity(inputModel, domainModel);
            return mapper.toOutput(service.recarregar(domainModel));
        } catch (DataIntegrityViolationException ex) {
            throw new NegocioException(ex);
        }
    }

    @Transactional
    public OutputModel atualizarParcial(Long id,
                                        HashMap<String,Object> fields) {
        try {
            DomainModel domainModel = service.buscar(id);
            mapper.patchEntity(fields, domainModel);
            return mapper.toOutput(service.recarregar(domainModel));
        } catch (DataIntegrityViolationException ex) {
            throw new NegocioException(ex);
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(Long id) {
        service.excluir(id);
    }
}
