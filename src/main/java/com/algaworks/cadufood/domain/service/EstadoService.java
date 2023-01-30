package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.core.generic.crud.service.GenericService;
import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.exception.negocio.EstadoNaoEncontradoException;
import com.algaworks.cadufood.domain.model.Estado;
import com.algaworks.cadufood.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoService extends GenericService<Estado> {

	@Autowired
	private EstadoRepository estadoRepository;

	@Override
	public Estado find(String estadoCodigo) {
		try{
			return super.find(estadoCodigo);
		}catch (EntidadeNaoEncontradaException ex){
			throw new EstadoNaoEncontradoException(Estado.class, estadoCodigo);
		}
	}

}
