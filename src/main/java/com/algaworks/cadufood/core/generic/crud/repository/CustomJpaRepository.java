package com.algaworks.cadufood.core.generic.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface CustomJpaRepository<T, ID> extends JpaRepository<T, ID> {

//    List<T> buscarPersonalizado(ParametrosBusca<T> parametrosBusca);

    T refresh(T t);

    void detach(T entity);

}
