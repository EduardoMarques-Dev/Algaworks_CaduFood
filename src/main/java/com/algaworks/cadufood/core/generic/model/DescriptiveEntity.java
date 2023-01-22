package com.algaworks.cadufood.core.generic.model;

public interface DescriptiveEntity extends GenericEntity {

   String getDescricao();

   @Override
   default String getNome(){
        return getDescricao();
    }

}
