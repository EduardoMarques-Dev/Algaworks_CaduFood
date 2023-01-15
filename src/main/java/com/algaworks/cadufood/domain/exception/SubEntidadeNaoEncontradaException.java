package com.algaworks.cadufood.domain.exception;

public class SubEntidadeNaoEncontradaException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public SubEntidadeNaoEncontradaException() {
        super("Sub-Entidade não encontrada");
    }

    public SubEntidadeNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public SubEntidadeNaoEncontradaException(Class classe) {
        super(classe);
    }

    public SubEntidadeNaoEncontradaException(Class classe, Long codigo) {
        super(classe, codigo);
    }
}
