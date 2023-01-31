package com.algaworks.cadufood.core.generic.model;

/**
 * Interface que representa uma entidade REST descritiva.
 *
 * Corresponde às entidades que não possuem o atributo 'nome',
 * criando então uma abstração que confere ao 'nome'
 * o atributo 'descricao'.v
 *
 * @author Carlos Eduardo Marques Pereira
 */
public interface EntidadeDescritiva extends EntidadeGenerica {

   String getDescricao();

   @Override
   default String getNome(){
        return getDescricao();
    }
}
