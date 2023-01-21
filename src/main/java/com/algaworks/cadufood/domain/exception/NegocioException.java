package com.algaworks.cadufood.domain.exception;

public class NegocioException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public NegocioException(String mensagem) {
        super(mensagem);
    }

    public NegocioException(RuntimeException ex) {
        super(categorizarException(ex));
    }

    private static String categorizarException(RuntimeException ex) {
        String mensagem = ex.getCause().getCause().getMessage();
        if (mensagem.contains("violates foreign key constraint")){
            mensagem = "Sub-entidade não foi encontrada na base de dados";
        }
        else if (mensagem.contains("violates not-null constraint")){
            mensagem = "Dados violam a restrição de não-nulo na base de dados";
        }
        else {
            mensagem = ex.getCause().getMessage();
        }
        return mensagem;
    }

    public NegocioException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
