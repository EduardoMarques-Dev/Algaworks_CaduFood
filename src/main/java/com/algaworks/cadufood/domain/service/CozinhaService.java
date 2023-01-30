package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.core.generic.crud.service.GenericService;
import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.exception.negocio.CozinhaNaoEncontradaException;
import com.algaworks.cadufood.domain.model.Cozinha;
import com.algaworks.cadufood.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CozinhaService extends GenericService<Cozinha> {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	@Override
	public Cozinha find(String cozinhaCodigo) {
		try {
			return super.find(cozinhaCodigo);
		}catch (EntidadeNaoEncontradaException ex){
			throw new CozinhaNaoEncontradaException(Cozinha.class, cozinhaCodigo);
		}
	}

}
