package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.api.controller.CozinhaController;
import com.algaworks.cadufood.api.model.input.CozinhaInput;
import com.algaworks.cadufood.domain.exception.CozinhaNaoEncontradaException;
import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.model.Cozinha;
import com.algaworks.cadufood.domain.repository.CozinhaRepository;
import com.algaworks.cadufood.domain.service.util.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CozinhaService extends GenericService<Cozinha> {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	@Autowired @Lazy
	private CozinhaController cozinhaController;

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

	@Transactional
	public Cozinha atualizar(Long cozinhaId, CozinhaInput cozinhaInput) {
		Cozinha cozinhaAtual = buscar(cozinhaId);

		cozinhaController.getMapper().updateEntity(cozinhaInput,cozinhaAtual);

		return cozinhaRepository.save(cozinhaAtual);
	}

}
