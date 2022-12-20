package com.algaworks.cadufood.domain.repository;

import com.algaworks.cadufood.domain.model.Restaurante;

import java.util.List;

public interface RestauranteRepository {

	List<Restaurante> listar();
	Restaurante buscar(Long id);
	Restaurante salvar(Restaurante restaurante);
	void remover(Restaurante restaurante);
	
}
