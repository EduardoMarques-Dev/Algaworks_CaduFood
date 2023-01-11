package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.domain.exception.CidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.model.Cidade;
import com.algaworks.cadufood.domain.repository.CidadeRepository;
import com.algaworks.cadufood.domain.service.util.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService extends GenericService<Cidade> {

	@Autowired
	private CidadeRepository cidadeRepository;

	public CidadeService(CidadeRepository repository) {
		super(repository);
	}

	@Override
	public Cidade buscar(Long idDomainModel) {
		try{
			return super.buscar(idDomainModel);
		}catch (EntidadeNaoEncontradaException ex){
			throw new CidadeNaoEncontradaException(Cidade.class,idDomainModel);
		}
	}

}
