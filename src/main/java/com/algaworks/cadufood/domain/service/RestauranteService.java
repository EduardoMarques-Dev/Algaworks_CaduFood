package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.domain.exception.EntidadeEmUsoException;
import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.model.Cozinha;
import com.algaworks.cadufood.domain.model.Restaurante;
import com.algaworks.cadufood.domain.repository.RestauranteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RestauranteService {

	private RestauranteRepository restauranteRepository;
	
	private CozinhaService cozinhaService;

	public List<Restaurante> listar() {
		List<Restaurante> restaurantes = restauranteRepository.findAll();
		return restaurantes;
	}

	public Restaurante buscar(Long restauranteId) {
		Restaurante restaurante = buscarRestauranteOuFalhar(restauranteId);
		return restaurante;
	}

	public List<Restaurante> buscarPorFrete(BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
		List<Restaurante> restaurantes = restauranteRepository
				.findByTaxaFreteBetween(taxaFreteInicial,taxaFreteFinal);
		return restaurantes;
	}

	public List<Restaurante> buscarPorNome(String nome, int quantidade) {
		List<Restaurante> restaurantes = new ArrayList<>();

		switch (quantidade){
			case 1:
				restaurantes = restauranteRepository.findFirstByNomeContaining(nome);
				break;
			case 2:
				restaurantes = restauranteRepository.findTop2ByNomeContaining(nome);
				break;
			default:
				restaurantes = restauranteRepository.buscarPorNome(nome);
		}
		return restaurantes;
	}

	public List<Restaurante> buscarPorNomeEFrete(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
		List<Restaurante> restaurantes = restauranteRepository.
				buscarPorNomeEFrete(nome,taxaFreteInicial, taxaFreteFinal);
		return restaurantes;
	}

	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaService.buscarCozinhaOuFalhar(cozinhaId);
		
		restaurante.setCozinha(cozinha);
		
		return restauranteRepository.save(restaurante);
	}

	public Restaurante atualizar(Long restauranteId, Restaurante restaurante) {
		Restaurante restauranteAtual = buscar(restauranteId);

		BeanUtils.copyProperties(restaurante, restauranteAtual, "id");

		return restauranteRepository.save(restauranteAtual);
	}

	public void excluir(Long restauranteId) {
		try {
			restauranteRepository.deleteById(restauranteId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de cozinha com código %d", restauranteId));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Cozinha de código %d não pode ser removida, pois está em uso", restauranteId));
		}
	}

	private Restaurante buscarRestauranteOuFalhar(Long restauranteId) {
		return restauranteRepository.findById(restauranteId).orElseThrow(
				() -> new EntidadeNaoEncontradaException(
						String.format("Não existe cadastro de cozinha com código %d", restauranteId))
		);
	}

}
