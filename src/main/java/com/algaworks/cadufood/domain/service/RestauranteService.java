package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.core.generic.crud.GenericService;
import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.exception.RestauranteNaoEncontradoException;
import com.algaworks.cadufood.domain.model.Restaurante;
import com.algaworks.cadufood.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestauranteService extends GenericService<Restaurante> {

	@Autowired
	private RestauranteRepository restauranteRepository;

	public RestauranteService(RestauranteRepository repository) {
		super(repository);
	}

	@Override
	public Restaurante buscar(Long idDomainModel) {
		try{
			return super.buscar(idDomainModel);
		}catch (EntidadeNaoEncontradaException ex){
			throw new RestauranteNaoEncontradoException(Restaurante.class,idDomainModel);
		}
	}

}