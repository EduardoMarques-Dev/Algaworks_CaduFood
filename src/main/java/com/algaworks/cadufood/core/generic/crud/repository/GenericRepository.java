package com.algaworks.cadufood.core.generic.crud.repository;

import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface GenericRepository <T, ID> extends CustomJpaRepository<T, ID> {

    Optional<T> findByCodigo(String codigo);

    void deleteByCodigo(String codigo);

}
