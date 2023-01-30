package com.algaworks.cadufood.core.generic.crud.controller;

import com.algaworks.cadufood.core.generic.crud.service.GenericService;
import com.algaworks.cadufood.core.generic.mapper.GenericMapper;
import com.algaworks.cadufood.core.generic.model.EntidadeGenerica;
import com.algaworks.cadufood.core.generic.model.ObjetoGenerico;
import com.algaworks.cadufood.domain.exception.NegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.List;

/**
 * Class representing a generic REST controller.
 *
 * @author Carlos Eduardo Marques Pereira
 */
public abstract class GenericController<
        DomainModel extends EntidadeGenerica,
        InputModel extends ObjetoGenerico,
        OutputModel extends ObjetoGenerico> {

    @Autowired
    protected GenericService<DomainModel> service;

    @Autowired
    protected GenericMapper<DomainModel, InputModel, OutputModel> mapper;

    public List<OutputModel> list() {
        return mapper.toOutputCollection(service.list());
    }

    public OutputModel find(String code) {
        DomainModel domainModel = service.find(code);
        return mapper.toOutput(domainModel);
    }

    @ResponseStatus(HttpStatus.CREATED)
    public OutputModel save(InputModel inputModel) {
        DomainModel domainModel = mapper.toDomain(inputModel);
        domainModel = service.save(domainModel);
        return mapper.toOutput(domainModel);
    }

    @Transactional
    public OutputModel update(String codigo,
                              InputModel inputModel) {
        try {
            DomainModel domainModel = service.find(codigo);
            mapper.updateEntity(inputModel, domainModel);
            return mapper.toOutput(service.refresh(domainModel));
        } catch (DataIntegrityViolationException ex) {
            throw new NegocioException(ex);
        }
    }

    @Transactional
    public OutputModel patch(String codigo,
                             HashMap<String,Object> fields) {
        try {
            DomainModel domainModel = service.find(codigo);
            mapper.patchEntity(fields, domainModel);
            return mapper.toOutput(service.refresh(domainModel));
        } catch (DataIntegrityViolationException ex) {
            throw new NegocioException(ex);
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(String codigo) {
        service.delete(codigo);
    }
}
