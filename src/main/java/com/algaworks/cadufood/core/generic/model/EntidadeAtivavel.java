package com.algaworks.cadufood.core.generic.model;

/**
 * Interface que representa uma entidade REST ativável.
 *
 * Corresponde às entidades que possuem controle de estado de ativação.
 *
 * @author Carlos Eduardo Marques Pereira
 */
public interface EntidadeAtivavel extends EntidadeGenerica {

    boolean isAtivo();

    void setAtivo(boolean ativo) ;

    void ativar();

    void inativar();
}
