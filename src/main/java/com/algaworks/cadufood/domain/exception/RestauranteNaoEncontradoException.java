package com.algaworks.cadufood.domain.exception;

public class RestauranteNaoEncontradoException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public RestauranteNaoEncontradoException(Class classe, Long codigo) {
        super(classe, codigo);
    }
}
