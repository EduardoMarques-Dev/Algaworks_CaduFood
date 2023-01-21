package com.algaworks.cadufood.domain.exception;

public class ViolacaoDeConstraintException extends NegocioException {

    public ViolacaoDeConstraintException() {
        super("Campos nulos tentaram ser persistidos em colunas não-nulas");
    }

    public ViolacaoDeConstraintException(String mensagem) {
        super(mensagem);
    }

    public ViolacaoDeConstraintException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
