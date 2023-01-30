package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.core.generic.crud.repository.RepositorioGenerico;
import com.algaworks.cadufood.core.generic.crud.service.ServicoConsultasAvancadas;
import com.algaworks.cadufood.core.generic.crud.service.ServicoGenerico;
import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.exception.negocio.RestauranteNaoEncontradoException;
import com.algaworks.cadufood.domain.model.Restaurante;
import com.algaworks.cadufood.domain.repository.RestauranteRepository;
import com.algaworks.cadufood.domain.repository.util.filter.RestauranteFiltros;
import com.algaworks.cadufood.infrastructure.repository.spec.RestauranteSpecs;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RestauranteService extends ServicoConsultasAvancadas<Restaurante, RestauranteFiltros> {

	public RestauranteService(RestauranteRepository repositorio, RestauranteSpecs restauranteSpecs) {
		super(repositorio, restauranteSpecs);
	}

	@Override
	public Restaurante buscar(String domainModelId) {
		try{
			return super.buscar(domainModelId);
		}catch (EntidadeNaoEncontradaException ex){
			throw new RestauranteNaoEncontradoException(Restaurante.class, domainModelId);
		}
	}

	@Transactional
	public void ativar(String restauranteCodigo){
		Restaurante restauranteAtual = buscar(restauranteCodigo);
		restauranteAtual.ativar();
	}

	@Transactional
	public void inativar(String restauranteCodigo){
		Restaurante restauranteAtual = buscar(restauranteCodigo);
		restauranteAtual.inativar();
	}

}