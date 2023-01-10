package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.api.controller.EstadoController;
import com.algaworks.cadufood.api.model.input.EstadoInput;
import com.algaworks.cadufood.domain.exception.EntidadeEmUsoException;
import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.exception.EstadoNaoEncontradoException;
import com.algaworks.cadufood.domain.model.Estado;
import com.algaworks.cadufood.domain.repository.EstadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired @Lazy
	private EstadoController estadoController;

	public List<Estado> listar() {
		List<Estado> estados = estadoRepository.findAll();
		return estados;
	}

	public Estado buscar(Long estadoId) {
		Estado estado = buscarEstado(estadoId);
		return estado;
	}

	@Transactional
	public Estado salvar(Estado estado) {
		return estadoRepository.save(estado);
	}

	@Transactional
	public Estado atualizar(Long estadoId, EstadoInput estadoInput) {
		Estado estadoAtual = buscar(estadoId);

		estadoController.getMapper().updateEntity(estadoInput, estadoAtual);

		return estadoRepository.save(estadoAtual);
	}

	@Transactional
	public void excluir(Long estadoId) {
		try {
			estadoRepository.deleteById(estadoId);
		} catch (EmptyResultDataAccessException e) {
			throw new EstadoNaoEncontradoException(
				String.format("Não existe um cadastro de estado com código %d", estadoId));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format("Estado de código %d não pode ser removido, pois está em uso", estadoId));
		}
	}

	public Estado buscarEstado(Long estadoId) {
		return estadoRepository.findById(estadoId)
				.orElseThrow(() ->
						new EstadoNaoEncontradoException(String.format("Não existe cadastro de estado com código %d", estadoId))
				);
	}
	
}
