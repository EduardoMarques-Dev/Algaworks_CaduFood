package com.algaworks.cadufood.core.generic.crud.controller;

import com.algaworks.cadufood.core.generic.crud.controller.apiannotations.DeleteAnnotations;
import com.algaworks.cadufood.core.generic.crud.controller.apiannotations.PostPutAnnotations;
import com.algaworks.cadufood.core.generic.model.DTO;
import com.algaworks.cadufood.core.generic.model.EntidadeGenerica;

import java.util.HashMap;

/**
 * Class representing a custom REST controller.
 * Provides a generic controller implementation,
 * without GET method mapping.
 *
 * @author Carlos Eduardo Marques Pereira
 */
public abstract class ExceptGetController<
            DomainModel extends EntidadeGenerica,
            InputModel extends DTO,
            OutputModel extends DTO>
        extends GenericController<DomainModel, InputModel, OutputModel>
        implements PostPutAnnotations<InputModel,OutputModel>, DeleteAnnotations {

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
