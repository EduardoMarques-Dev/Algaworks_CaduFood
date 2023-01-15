package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.core.generic.crud.GenericService;
import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.exception.EstadoNaoEncontradoException;
import com.algaworks.cadufood.domain.model.Estado;
import com.algaworks.cadufood.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoService extends GenericService<Estado> {

	@Autowired
	private EstadoRepository estadoRepository;

	public EstadoService(EstadoRepository repository) {
		super(repository);
	}

	@Override
	public Estado buscar(Long domainModelId) {
		try{
			return super.buscar(domainModelId);
		}catch (EntidadeNaoEncontradaException ex){
			throw new EstadoNaoEncontradoException(Estado.class, domainModelId);
		}
	}

}
