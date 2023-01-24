package com.algaworks.cadufood.core.generic.crud.controller;

import com.algaworks.cadufood.core.generic.crud.controller.apiannotations.AllApiAnnotations;
import com.algaworks.cadufood.core.generic.model.DataTransferObject;
import com.algaworks.cadufood.core.generic.model.GenericEntity;

import java.util.HashMap;
import java.util.List;

public abstract class BasicController<
        DomainModel extends GenericEntity,
        InputModel extends DataTransferObject,
        OutputModel extends DataTransferObject>
        extends GenericController<DomainModel, InputModel, OutputModel>
        implements AllApiAnnotations<InputModel,OutputModel> {

    @Override
    public List<OutputModel> listar() {
        return super.listar();
    }

    @Override
    public OutputModel buscar(String codigo) {
        return super.buscar(codigo);
    }

    @Override
    public OutputModel salvar(InputModel inputModel) {
        return super.salvar(inputModel);
    }

    @Override
    public OutputModel atualizar(String codigo, InputModel inputModel) {
        return super.atualizar(codigo, inputModel);
    }

    @Override
    public OutputModel atualizarParcial(String codigo, HashMap<String, Object> fields) {
        return super.atualizarParcial(codigo, fields);
    }

    @Override
    public void excluir(String codigo) {
        super.excluir(codigo);
    }
}
