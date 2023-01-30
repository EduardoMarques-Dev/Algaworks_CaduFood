package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.core.generic.crud.service.GenericService;
import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.exception.negocio.CidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.model.Cidade;
import com.algaworks.cadufood.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService extends GenericService<Cidade> {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Override
	public Cidade find(String cidadeCodigo) {
		try{
			return super.find(cidadeCodigo);
		}catch (EntidadeNaoEncontradaException ex){
			throw new CidadeNaoEncontradaException(Cidade.class, cidadeCodigo);
		}
	}

}
