package com.algaworks.cadufood.domain.repository.util.norepositorybean;

import com.algaworks.cadufood.domain.repository.util.interfacequeries.ParametrosBusca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/* Anotação que informa ao Spring para não instanciar uma implementação
   Para este repositório
*/
@NoRepositoryBean
public interface CustomJpaRepository<T, ID> extends JpaRepository<T, ID> {

    @Transactional
    T refresh(T t);

    List<T> buscarPersonalizado(ParametrosBusca<T> parametrosBusca);

    Optional<T> buscarPrimeiro();


}
