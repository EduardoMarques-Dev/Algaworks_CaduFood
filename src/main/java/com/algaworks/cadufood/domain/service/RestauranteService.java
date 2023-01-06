package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.model.Cozinha;
import com.algaworks.cadufood.domain.model.Restaurante;
import com.algaworks.cadufood.domain.repository.RestauranteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
		Restaurante restaurante = buscarRestaurante(restauranteId);
		return restaurante;
	}


	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaService.buscarCozinha(cozinhaId);
		
		restaurante.setCozinha(cozinha);
		
		return restauranteRepository.save(restaurante);
	}

	private Restaurante buscarRestaurante(Long restauranteId) {
		return restauranteRepository.findById(restauranteId).orElseThrow(
				() -> new EntidadeNaoEncontradaException(
						String.format("Não existe cadastro de cozinha com código %d", restauranteId))
		);
	}

}
