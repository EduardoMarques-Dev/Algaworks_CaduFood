package com.algaworks.cadufood.domain.repository;

import com.algaworks.cadufood.core.generic.crud.CustomJpaRepository;
import com.algaworks.cadufood.domain.model.Permissao;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissaoRepository extends CustomJpaRepository<Permissao, Long> {

}
