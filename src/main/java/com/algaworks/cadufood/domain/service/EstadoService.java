package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.domain.exception.EntidadeEmUsoException;
import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.model.Estado;
import com.algaworks.cadufood.domain.repository.EstadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EstadoService {

	private EstadoRepository estadoRepository;


	public List<Estado> listar() {
		List<Estado> estados = estadoRepository.findAll();
		return estados;
	}

	public Estado buscar(Long estadoId) {
		Estado estado = buscarEstado(estadoId);
		return estado;
	}

	public Estado salvar(Estado estado) {
		return estadoRepository.save(estado);
	}
	
	public void excluir(Long estadoId) {
		try {
			estadoRepository.deleteById(estadoId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
				String.format("Não existe um cadastro de estado com código %d", estadoId));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format("Estado de código %d não pode ser removido, pois está em uso", estadoId));
		}
	}

	public Estado buscarEstado(Long estadoId) {
		return estadoRepository.findById(estadoId)
				.orElseThrow(() ->
						new EntidadeNaoEncontradaException(String.format("Não existe cadastro de estado com código %d", estadoId))
				);
	}
	
}
