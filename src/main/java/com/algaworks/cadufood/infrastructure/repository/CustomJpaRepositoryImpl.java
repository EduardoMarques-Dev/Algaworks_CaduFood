package com.algaworks.cadufood.infrastructure.repository;

import com.algaworks.cadufood.domain.repository.util.norepositorybean.CustomJpaRepository;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Optional;

public class CustomJpaRepositoryImpl<T,ID> extends SimpleJpaRepository<T,ID>
        implements CustomJpaRepository<T,ID>, Serializable {

    private EntityManager manager;

    public CustomJpaRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);

        this.manager = entityManager;
    }

    @Override
    @Transactional
    public T refresh(T t) {
        manager.refresh(t);
        return t;
    }

    @Override
    public Optional<T> buscarPrimeiro() {
        var jpql = "from " + getDomainClass().getName();

        T entity = manager.createQuery(jpql, getDomainClass())
                .setMaxResults(1)
                .getSingleResult();

        return Optional.ofNullable(entity);
    }
}
