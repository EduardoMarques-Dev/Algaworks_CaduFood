package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.api.controller.CozinhaController;
import com.algaworks.cadufood.api.model.input.CozinhaInput;
import com.algaworks.cadufood.domain.exception.EntidadeEmUsoException;
import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.model.Cozinha;
import com.algaworks.cadufood.domain.repository.CozinhaRepository;
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
public class CozinhaService {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	@Autowired @Lazy
	private CozinhaController cozinhaController;


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
	public Cozinha atualizar(Long cozinhaId, CozinhaInput cozinhaInput) {
		Cozinha cozinhaAtual = buscar(cozinhaId);

		cozinhaController.getMapper().updateEntity(cozinhaInput,cozinhaAtual);

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
