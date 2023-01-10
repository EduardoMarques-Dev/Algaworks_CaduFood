package com.algaworks.cadufood.domain.exception;

public class EntidadeEmUsoException extends NegocioException {

	private static final long serialVersionUID = 1L;

	public EntidadeEmUsoException(String mensagem) {
		super(mensagem);
	}

	public EntidadeEmUsoException(Class classe, Long codigo) {
		super(String.format("O objeto %s de código %d não pode ser removido, pois está em uso", classe.getSimpleName(), codigo));
	}
	
}
