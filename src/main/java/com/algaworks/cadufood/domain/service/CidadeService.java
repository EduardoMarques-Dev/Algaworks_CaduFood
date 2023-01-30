package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.core.generic.crud.repository.RepositorioGenerico;
import com.algaworks.cadufood.core.generic.crud.service.ServicoGenerico;
import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.exception.negocio.CidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.model.Cidade;
import com.algaworks.cadufood.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService extends ServicoGenerico<Cidade> {

	public CidadeService(CidadeRepository repositorio) {
		super(repositorio);
	}

	@Override
	public Cidade buscar(String cidadeCodigo) {
		try{
			return super.buscar(cidadeCodigo);
		}catch (EntidadeNaoEncontradaException ex){
			throw new CidadeNaoEncontradaException(Cidade.class, cidadeCodigo);
		}
	}

}
