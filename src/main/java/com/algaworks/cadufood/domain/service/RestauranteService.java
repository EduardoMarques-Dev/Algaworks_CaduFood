package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.core.generic.crud.service.GenericService;
import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.exception.negocio.RestauranteNaoEncontradoException;
import com.algaworks.cadufood.domain.model.Restaurante;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RestauranteService extends GenericService<Restaurante> {

	@Override
	public Restaurante find(String domainModelId) {
		try{
			return super.find(domainModelId);
		}catch (EntidadeNaoEncontradaException ex){
			throw new RestauranteNaoEncontradoException(Restaurante.class, domainModelId);
		}
	}

	@Transactional
	public void ativar(String restauranteCodigo){
		Restaurante restauranteAtual = find(restauranteCodigo);
		restauranteAtual.ativar();
	}

	@Transactional
	public void inativar(String restauranteCodigo){
		Restaurante restauranteAtual = find(restauranteCodigo);
		restauranteAtual.inativar();
	}

}