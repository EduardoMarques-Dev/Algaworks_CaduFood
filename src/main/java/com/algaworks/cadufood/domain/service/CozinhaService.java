package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.domain.exception.EntidadeEmUsoException;
import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.model.Cozinha;
import com.algaworks.cadufood.domain.repository.CozinhaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CozinhaService {

	private CozinhaRepository cozinhaRepository;

	public List<Cozinha> listar() {
		List<Cozinha> cozinhas = cozinhaRepository.findAll();
		return cozinhas;
	}

	public Cozinha buscar(Long cozinhaId) {
		Cozinha cozinha = buscarCozinhaOuFalhar(cozinhaId);
		return cozinha;
	}
	@Transactional
	public Cozinha salvar(Cozinha cozinha) {
		return cozinhaRepository.save(cozinha);
	}

	@Transactional
	public Cozinha atualizar(Long cozinhaId, Cozinha cozinha) {
		Cozinha cozinhaAtual = buscar(cozinhaId);

		BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");

		return cozinhaRepository.save(cozinhaAtual);
	}

	@Transactional
	public void excluir(Long cozinhaId) {
		try {
			cozinhaRepository.deleteById(cozinhaId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
				String.format("Não existe um cadastro de cozinha com código %d", cozinhaId));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format("Cozinha de código %d não pode ser removida, pois está em uso", cozinhaId));
		}
	}

	public Cozinha buscarCozinhaOuFalhar(Long cozinhaId) {
		return cozinhaRepository.findById(cozinhaId).orElseThrow(
				() -> new EntidadeNaoEncontradaException(cozinhaId.toString())
		);
	}
	
}
