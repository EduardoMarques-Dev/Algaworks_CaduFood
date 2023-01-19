package com.algaworks.cadufood.domain.exception.negocio;

import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;

public class CidadeNaoEncontradaException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;
    
    public CidadeNaoEncontradaException(Class classe, Long codigo) {
        super(classe, codigo);
    }
}
