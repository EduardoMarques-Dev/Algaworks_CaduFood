package com.algaworks.cadufood.core.generic.model;

/**
 * Interface que representa uma entidade REST descritiva.
 *
 * Como algumas entidades não possuem o atributo 'nome',
 * esta interface cria uma abstração conferindo ao 'nome'
 * o atributo 'descricao'.
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
