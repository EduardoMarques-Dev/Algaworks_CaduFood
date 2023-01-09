package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.domain.exception.EntidadeEmUsoException;
import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.model.Cidade;
import com.algaworks.cadufood.domain.model.Estado;
import com.algaworks.cadufood.domain.repository.CidadeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CidadeService {

	private CidadeRepository cidadeRepository;

	private EstadoService estadoService;

	public List<Cidade> listar() {
		List<Cidade> cidades = cidadeRepository.findAll();
		return cidades;
	}

	public Cidade buscar(Long cidadeId) {
		Cidade cidade = buscarCidade(cidadeId);
		return cidade;
	}

	@Transactional
	public Cidade salvar(Cidade cidade) {
		Long estadoId = cidade.getEstado().getId();
		Estado estado = estadoService.buscarEstado(estadoId);

		cidade.setEstado(estado);

		return cidadeRepository.save(cidade);
	}

	@Transactional
	public Cidade atualizar(Long cidadeId, Cidade cidade) {
		Cidade cidadeAtual = buscar(cidadeId);

		BeanUtils.copyProperties(cidade, cidadeAtual, "id");

		return cidadeRepository.save(cidadeAtual);
	}

	@Transactional
	public void excluir(Long cidadeId) {
		try {
			cidadeRepository.deleteById(cidadeId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de cidade com código %d", cidadeId));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Cidade de código %d não pode ser removida, pois está em uso", cidadeId));
		}
	}

	public Cidade buscarCidade(Long cidadeId) {
		return cidadeRepository.findById(cidadeId).orElseThrow(
				() -> new EntidadeNaoEncontradaException(cidadeId.toString())
		);
	}

}
