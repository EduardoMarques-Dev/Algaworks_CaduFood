package com.algaworks.cadufood.core.generic.crud.controller;

import com.algaworks.cadufood.core.generic.crud.controller.apiannotations.AllApiAnnotations;
import com.algaworks.cadufood.core.generic.model.DTO;
import com.algaworks.cadufood.core.generic.model.EntidadeGenerica;

import java.util.HashMap;
import java.util.List;

/**
 * Class representing a basic REST controller.
 * Provides a generic controller implementation,
 * with all methods mapped.
 *
 * @author Carlos Eduardo Marques Pereira
 */
public abstract class BasicController<
        DomainModel extends EntidadeGenerica,
        InputModel extends DTO,
        OutputModel extends DTO>
        extends GenericController<DomainModel, InputModel, OutputModel>
        implements AllApiAnnotations<InputModel,OutputModel> {

    @Override
    public List<OutputModel> list() {
        return super.list();
    }

    @Override
    public OutputModel find(String code) {
        return super.find(code);
    }

    @Override
    public OutputModel save(InputModel inputModel) {
        return super.save(inputModel);
    }

    @Override
    public OutputModel update(String codigo, InputModel inputModel) {
        return super.update(codigo, inputModel);
    }

    @Override
    public OutputModel patch(String codigo, HashMap<String, Object> fields) {
        return super.patch(codigo, fields);
    }

    @Override
    public void delete(String codigo) {
        super.delete(codigo);
    }
}
