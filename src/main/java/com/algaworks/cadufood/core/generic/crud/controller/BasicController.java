package com.algaworks.cadufood.core.generic.crud.controller;

import com.algaworks.cadufood.core.generic.crud.controller.apiannotations.AllApiAnnotations;
import com.algaworks.cadufood.core.generic.crud.service.GenericService;
import com.algaworks.cadufood.core.generic.mapper.GenericMapper;
import com.algaworks.cadufood.core.generic.model.DataTransferObject;
import com.algaworks.cadufood.core.generic.model.GenericEntity;

import java.util.HashMap;
import java.util.List;

public abstract class BasicController<
        DomainModel extends GenericEntity<DomainModel>,
        InputModel extends DataTransferObject<InputModel>,
        OutputModel extends DataTransferObject<OutputModel>>
        extends GenericController<DomainModel, InputModel, OutputModel>
        implements AllApiAnnotations<InputModel,OutputModel> {

    public BasicController(GenericService<DomainModel> service, GenericMapper<DomainModel, InputModel, OutputModel> mapper) {
        super(service, mapper);
    }

    @Override
    public List<OutputModel> listar() {
        return super.listar();
    }

    @Override
    public OutputModel buscar(Long id) {
        return super.buscar(id);
    }

    @Override
    public OutputModel salvar(InputModel inputModel) {
        return super.salvar(inputModel);
    }

    @Override
    public OutputModel atualizar(Long id, InputModel inputModel) {
        return super.atualizar(id, inputModel);
    }

    @Override
    public OutputModel atualizarParcial(Long id, HashMap<String, Object> fields) {
        return super.atualizarParcial(id, fields);
    }

    @Override
    public void excluir(Long id) {
        super.excluir(id);
    }

}