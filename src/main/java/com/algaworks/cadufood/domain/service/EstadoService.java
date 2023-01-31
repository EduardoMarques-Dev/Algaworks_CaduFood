package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.core.generic.crud.service.ServicoGenerico;
import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.exception.negocio.EstadoNaoEncontradoException;
import com.algaworks.cadufood.domain.model.Estado;
import com.algaworks.cadufood.domain.repository.EstadoRepository;
import org.springframework.stereotype.Service;

@Service
public class EstadoService extends ServicoGenerico<Estado> {

	public EstadoService(EstadoRepository repositorio) {
		super(repositorio);
	}

	@Override
	public Estado buscar(String estadoCodigo) {
		try{
			return super.buscar(estadoCodigo);
		}catch (EntidadeNaoEncontradaException ex){
			throw new EstadoNaoEncontradoException(Estado.class, estadoCodigo);
		}
	}

}
