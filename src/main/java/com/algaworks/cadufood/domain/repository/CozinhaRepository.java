package com.algaworks.cadufood.domain.repository;

import com.algaworks.cadufood.core.generic.crud.repository.CustomJpaRepository;
import com.algaworks.cadufood.domain.model.Cozinha;
import org.springframework.stereotype.Repository;

@Repository
public interface CozinhaRepository extends CustomJpaRepository<Cozinha, Long> {

}
