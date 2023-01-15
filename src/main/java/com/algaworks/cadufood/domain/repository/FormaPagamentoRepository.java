package com.algaworks.cadufood.domain.repository;

import com.algaworks.cadufood.core.generic.crud.CustomJpaRepository;
import com.algaworks.cadufood.domain.model.FormaPagamento;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaPagamentoRepository extends CustomJpaRepository<FormaPagamento, Long> {

}
