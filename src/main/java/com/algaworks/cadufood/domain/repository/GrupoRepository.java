package com.algaworks.cadufood.domain.repository;

import com.algaworks.cadufood.core.generic.crud.CustomJpaRepository;
import com.algaworks.cadufood.domain.model.Grupo;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends CustomJpaRepository<Grupo, Long> {
}
