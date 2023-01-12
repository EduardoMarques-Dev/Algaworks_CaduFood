package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.domain.exception.CozinhaNaoEncontradaException;
import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.model.Cozinha;
import com.algaworks.cadufood.domain.repository.CozinhaRepository;
import com.algaworks.cadufood.core.generic.crud.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CozinhaService extends GenericService<Cozinha> {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	public CozinhaService(CozinhaRepository repository) {
		super(repository);
	}

	@Override
	public Cozinha buscar(Long idDomainModel) {
		try {
			return super.buscar(idDomainModel);
		}catch (EntidadeNaoEncontradaException ex){
			throw new CozinhaNaoEncontradaException(Cozinha.class,idDomainModel);
		}
	}

}
