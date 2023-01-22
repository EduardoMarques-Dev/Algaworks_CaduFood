package com.algaworks.cadufood.domain.exception;

public class EntidadeNaoEncontradaException extends NegocioException {

	private static final long serialVersionUID = 1L;

	public static final String NAO_EXISTE = "Não existe registro";

	public static final String NAO_EXISTE_CODIGO
			= "Não existe registro de código %s";

	public static final String NAO_EXISTE_OBJETO
			= "Não existe registro do objeto %s";

	public static final String NAO_EXISTE_CADASTRO_COM_CODIGO
			= "Não existe registro do objeto %s com código %s";

	public EntidadeNaoEncontradaException() {
		super(NAO_EXISTE);
	}

	public EntidadeNaoEncontradaException(String codigo) {
		super(String.format(NAO_EXISTE_CODIGO, codigo));
	}

	public EntidadeNaoEncontradaException(Class classe) {
		super(String.format(NAO_EXISTE_OBJETO, classe.getSimpleName()));
	}

	public EntidadeNaoEncontradaException(Class classe, String codigo) {
		super(String.format(NAO_EXISTE_CADASTRO_COM_CODIGO, classe.getSimpleName(), codigo));
	}

}
