package com.algaworks.cadufood.domain.exception;

public class SenhaIncorretaException extends NegocioException {

    private static final long serialVersionUID = 1L;

    public static final String SENHA_INCORRETA = "A senha informada está incorreta";

    public SenhaIncorretaException() {
        super(SENHA_INCORRETA);
    }

    public SenhaIncorretaException(String mensagem) {
        super(mensagem);
    }

    public SenhaIncorretaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
