package com.algaworks.cadufood.core.generic.mapper;

import java.util.HashMap;

// Comentários: Utilizado quando a classe possui Foreign Keys
// Que precisam ser desanexadas para a atualização do recurso
public abstract class DetachedKeyMapper<DomainModel, InputModel, OutputModel> extends GenericMapper<DomainModel, InputModel, OutputModel> {

    public DetachedKeyMapper(Class<DomainModel> domainClass, Class<InputModel> inputClass, Class<OutputModel> outputClass) {
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
