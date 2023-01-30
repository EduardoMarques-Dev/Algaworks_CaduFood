package com.algaworks.cadufood.core.generic.crud.controller;

import com.algaworks.cadufood.core.generic.crud.controller.apiannotations.DeleteAnnotations;
import com.algaworks.cadufood.core.generic.crud.controller.apiannotations.PostPutAnnotations;
import com.algaworks.cadufood.core.generic.model.DataTransferObject;
import com.algaworks.cadufood.core.generic.model.GenericEntity;

import java.util.HashMap;

/**
 * Class representing a custom REST controller.
 * Provides a generic controller implementation,
 * without GET method mapping.
 *
 * @author Carlos Eduardo Marques Pereira
 */
public abstract class ExceptGetController<
            DomainModel extends GenericEntity,
            InputModel extends DataTransferObject,
            OutputModel extends DataTransferObject>
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
