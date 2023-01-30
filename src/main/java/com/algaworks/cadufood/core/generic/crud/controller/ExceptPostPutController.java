package com.algaworks.cadufood.core.generic.crud.controller;

import com.algaworks.cadufood.core.generic.crud.controller.apiannotations.DeleteAnnotations;
import com.algaworks.cadufood.core.generic.crud.controller.apiannotations.GetAnnotations;
import com.algaworks.cadufood.core.generic.model.DTO;
import com.algaworks.cadufood.core.generic.model.EntidadeGenerica;

import java.util.List;

/**
 * Class representing a custom REST controller.
 * Provides a generic controller implementation,
 * without POST and PUT method mapping.
 *
 * @author Carlos Eduardo Marques Pereira
 */
public abstract class ExceptPostPutController<
            DomainModel extends EntidadeGenerica,
            InputModel extends DTO,
            OutputModel extends DTO>
        extends GenericController<DomainModel, InputModel, OutputModel>
        implements GetAnnotations<OutputModel>, DeleteAnnotations {

    @Override
    public List<OutputModel> list() {
        return super.list();
    }

    @Override
    public OutputModel find(String code) {
        return super.find(code);
    }

    @Override
    public void delete(String codigo) {
        super.delete(codigo);
    }
}
