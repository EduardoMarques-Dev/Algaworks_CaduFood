package com.algaworks.cadufood.domain.repository;

import com.algaworks.cadufood.core.generic.crud.CustomJpaRepository;
import com.algaworks.cadufood.domain.model.Estado;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends CustomJpaRepository<Estado, Long> {
	
}
