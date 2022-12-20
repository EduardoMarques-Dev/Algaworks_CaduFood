package com.algaworks.cadufood.domain.repository;

import com.algaworks.cadufood.domain.model.Estado;

import java.util.List;

public interface EstadoRepository {

	List<Estado> listar();
	Estado buscar(Long id);
	Estado salvar(Estado estado);
	void remover(Long id);
	
}
