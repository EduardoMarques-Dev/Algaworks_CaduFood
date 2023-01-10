package com.algaworks.cadufood.domain.exception;

public class EstadoNaoEncontradoException extends EntidadeNaoEncontradaException{

    private static final long serialVersionUID = 1L;

    public EstadoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public EstadoNaoEncontradoException(Class classe) {
        super(classe);
    }

    public EstadoNaoEncontradoException(Class classe, Long codigo) {
        super(classe, codigo);
    }
}
