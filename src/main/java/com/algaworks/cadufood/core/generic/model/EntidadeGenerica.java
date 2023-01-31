package com.algaworks.cadufood.core.generic.model;

/**
 * Interface que representa uma entidade REST genérica.
 *
 * @author Carlos Eduardo Marques Pereira
 */
public interface EntidadeGenerica extends ObjetoGenerico {

    Long getId();

    String getCodigo();

    void setCodigo(String codigo);

    String getNome();

    /**
     * Método responsável por gerar o código da entidade.
     * Ao implementar deve anota-lo com @Prepersist para
     * que o método seja chamado automaticamente antes
     * de persistir a entidade.
     */
    void gerarCodigo();

}
