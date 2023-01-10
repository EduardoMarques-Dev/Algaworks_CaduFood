package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.api.controller.EstadoController;
import com.algaworks.cadufood.api.model.input.EstadoInput;
import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.exception.EstadoNaoEncontradoException;
import com.algaworks.cadufood.domain.model.Estado;
import com.algaworks.cadufood.domain.repository.EstadoRepository;
import com.algaworks.cadufood.domain.service.util.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstadoService extends GenericService<Estado> {

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired @Lazy
	private EstadoController estadoController;

	public EstadoService(EstadoRepository repository) {
		super(repository);
	}

	@Override
	public Estado buscar(Long idDomainModel) {
		try{
			return super.buscar(idDomainModel);
		}catch (EntidadeNaoEncontradaException ex){
			throw new EstadoNaoEncontradoException(Estado.class,idDomainModel);
		}
	}

	@Transactional
	public Estado atualizar(Long estadoId, EstadoInput estadoInput) {
		Estado estadoAtual = buscar(estadoId);

		estadoController.getMapper().updateEntity(estadoInput, estadoAtual);

		return estadoRepository.save(estadoAtual);
	}

}
