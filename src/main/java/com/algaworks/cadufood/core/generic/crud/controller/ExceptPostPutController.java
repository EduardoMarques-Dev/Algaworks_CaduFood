package com.algaworks.cadufood.core.generic.crud.controller;

import com.algaworks.cadufood.core.generic.crud.controller.apiannotations.DeleteAnnotations;
import com.algaworks.cadufood.core.generic.crud.controller.apiannotations.GetAnnotations;
import com.algaworks.cadufood.core.generic.model.DataTransferObject;
import com.algaworks.cadufood.core.generic.model.GenericEntity;

import java.util.List;

public abstract class ExceptPostPutController<
            DomainModel extends GenericEntity,
            InputModel extends DataTransferObject,
            OutputModel extends DataTransferObject>
        extends GenericController<DomainModel, InputModel, OutputModel>
        implements GetAnnotations<OutputModel>, DeleteAnnotations {

    @Override
    public List<OutputModel> listar() {
        return super.listar();
    }

    @Override
    public OutputModel buscar(String codigo) {
        return super.buscar(codigo);
    }

    @Override
    public void excluir(String codigo) {
        super.excluir(codigo);
    }
}
