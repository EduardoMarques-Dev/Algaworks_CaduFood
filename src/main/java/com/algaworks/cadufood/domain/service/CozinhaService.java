package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.core.generic.crud.service.ServicoGenerico;
import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.exception.negocio.CozinhaNaoEncontradaException;
import com.algaworks.cadufood.domain.model.Cozinha;
import com.algaworks.cadufood.domain.repository.CozinhaRepository;
import org.springframework.stereotype.Service;

@Service
public class CozinhaService extends ServicoGenerico<Cozinha> {

	public CozinhaService(CozinhaRepository repositorio) {
		super(repositorio);
	}

	@Override
	public Cozinha buscar(String cozinhaCodigo) {
		try {
			return super.buscar(cozinhaCodigo);
		}catch (EntidadeNaoEncontradaException ex){
			throw new CozinhaNaoEncontradaException(Cozinha.class, cozinhaCodigo);
		}
	}

}
