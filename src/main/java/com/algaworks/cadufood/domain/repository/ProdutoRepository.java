package com.algaworks.cadufood.domain.repository;

import com.algaworks.cadufood.core.generic.crud.repository.GenericRepository;
import com.algaworks.cadufood.domain.model.Produto;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends GenericRepository<Produto, Long> {

}
