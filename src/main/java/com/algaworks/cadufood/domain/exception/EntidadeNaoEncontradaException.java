package com.algaworks.cadufood.domain.exception;

public abstract class EntidadeNaoEncontradaException extends NegocioException {

	private static final long serialVersionUID = 1L;

	public static final String NAO_EXISTE_CADASTRO
			= "Não existe cadastro do objeto %s";

	public static final String NAO_EXISTE_CADASTRO_COM_CODIGO
			= "Não existe cadastro do objeto %s com código %d";

	public EntidadeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

	public EntidadeNaoEncontradaException(Class classe) {
		super(String.format(NAO_EXISTE_CADASTRO, classe.getSimpleName()));
	}

	public EntidadeNaoEncontradaException(Class classe, Long codigo) {
		super(String.format(NAO_EXISTE_CADASTRO_COM_CODIGO, classe.getSimpleName(), codigo));
	}

}
