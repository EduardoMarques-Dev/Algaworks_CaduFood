package com.algaworks.cadufood.core.generic.crud.repository;

import com.algaworks.cadufood.core.generic.model.GenericEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;


/**
 * Class representing a generic REST repository.
 *
 * @author Carlos Eduardo Marques Pereira
 *
 * Comentários:
 * A anotação @NoRepositoryBean informa ao Spring para não instanciar uma implementação
 * para este repositório
 */
@NoRepositoryBean
public interface GenericRepository <DomainModel extends GenericEntity, ID> extends CustomJpaRepository<DomainModel, ID>,
        JpaSpecificationExecutor<DomainModel> {

    Optional<DomainModel> findByCodigo(String codigo);

    void deleteByCodigo(String codigo);

}
