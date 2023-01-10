package com.algaworks.cadufood.domain.exception;

public class CozinhaNaoEncontradaException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public CozinhaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public CozinhaNaoEncontradaException(Class classe) {
        super(classe);
    }

    public CozinhaNaoEncontradaException(Class classe, Long codigo) {
        super(classe, codigo);
    }
}
