package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.core.generic.crud.repository.GenericRepository;
import com.algaworks.cadufood.core.generic.crud.service.GenericService;
import com.algaworks.cadufood.core.generic.filter.GenericSpec;
import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.exception.negocio.RestauranteNaoEncontradoException;
import com.algaworks.cadufood.domain.model.Restaurante;
import com.algaworks.cadufood.domain.repository.RestauranteRepository;
import com.algaworks.cadufood.domain.repository.util.filter.RestauranteFiltros;
import com.algaworks.cadufood.infrastructure.repository.spec.RestauranteSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RestauranteService extends GenericService<Restaurante> {

	public RestauranteService(GenericRepository<Restaurante, Long> repository, GenericSpec<Restaurante> genericSpec) {
		super(repository, genericSpec);
	}

	@Override
	public Restaurante buscar(String domainModelId) {
		System.out.println("ulala");
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