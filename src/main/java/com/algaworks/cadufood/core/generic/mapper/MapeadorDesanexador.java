package com.algaworks.cadufood.core.generic.mapper;

import java.util.HashMap;

/**
 * Classe que representa um mapeador REST com tratativa de desanexação.
 *
 * Utilizado quando a classe possui Foreign Keys Que precisam
 * ser desanexadas para a atualização do recurso.
 *
 * @author Carlos Eduardo Marques Pereira
 */
public abstract class MapeadorDesanexador<DomainModel, InputModel, OutputModel> extends MapeadorGenerico<DomainModel, InputModel, OutputModel> {

    public MapeadorDesanexador(Class<DomainModel> domainClass, Class<InputModel> inputClass, Class<OutputModel> outputClass) {
        super(domainClass, inputClass, outputClass);
    }

    @Override
    public void updateEntity(InputModel newEntity, DomainModel currentEntity) {
        detachForeignKey(currentEntity);
        modelMapper.map(newEntity, currentEntity);
    }

    @Override
    public void patchEntity(HashMap<String, Object> fields, DomainModel currentEntity) {
        detachForeignKey(currentEntity);
        modelMapper.map(fields, currentEntity);
    }

    protected abstract void detachForeignKey(DomainModel domainModel);

}
