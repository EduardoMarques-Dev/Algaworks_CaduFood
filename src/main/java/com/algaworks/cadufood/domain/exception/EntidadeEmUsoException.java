package com.algaworks.cadufood.domain.exception;

public class EntidadeEmUsoException extends NegocioException {

	private static final long serialVersionUID = 1L;
	public static final String EM_USO = "Entidade em uso";

	public EntidadeEmUsoException(String mensagem) {super(mensagem);}

	public EntidadeEmUsoException() {
		super(EM_USO);
	}

	public EntidadeEmUsoException(Class classe, Long codigo) {
		super(String.format("O objeto %s de código %d não pode ser removido, pois está em uso", classe.getSimpleName(), codigo));
	}

}
