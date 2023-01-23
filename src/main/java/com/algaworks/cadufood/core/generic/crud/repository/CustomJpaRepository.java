package com.algaworks.cadufood.core.generic.crud.repository;

import com.algaworks.cadufood.core.generic.ParametrosBusca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

// Comentários: Anotação que informa ao Spring para não instanciar uma implementação
// Para este repositório
@NoRepositoryBean
public interface CustomJpaRepository<T, ID> extends JpaRepository<T, ID> {
    List<T> buscarPersonalizado(ParametrosBusca<T> parametrosBusca);

    T refresh(T t);

    void detach(T entity);

}
