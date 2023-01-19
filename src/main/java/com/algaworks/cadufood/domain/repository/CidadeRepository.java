package com.algaworks.cadufood.domain.repository;

import com.algaworks.cadufood.core.generic.crud.repository.CustomJpaRepository;
import com.algaworks.cadufood.domain.model.Cidade;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends CustomJpaRepository<Cidade, Long> {

}
