package com.algaworks.cadufood.domain.exception;

public class EntidadeNaoEncontradaException extends NegocioException {

	private static final long serialVersionUID = 1L;

	public static final String NAO_EXISTE_OBJETO
			= "Não existe registro do objeto %s";

	public static final String NAO_EXISTE_CODIGO
			= "Não existe registro de código %d";

	public static final String NAO_EXISTE_CADASTRO_COM_CODIGO
			= "Não existe registro do objeto %s com código %d";

	public EntidadeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

	public EntidadeNaoEncontradaException(Class classe) {
		super(String.format(NAO_EXISTE_OBJETO, classe.getSimpleName()));
	}

	public EntidadeNaoEncontradaException(Long codigo) {
		super(String.format(NAO_EXISTE_CODIGO, codigo));
	}

	public EntidadeNaoEncontradaException(Class classe, Long codigo) {
		super(String.format(NAO_EXISTE_CADASTRO_COM_CODIGO, classe.getSimpleName(), codigo));
	}

}
