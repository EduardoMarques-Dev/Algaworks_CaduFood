package com.algaworks.cadufood.infrastructure.repository;

import com.algaworks.cadufood.core.generic.ParametrosBusca;
import com.algaworks.cadufood.core.generic.crud.CustomJpaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CustomJpaRepositoryImpl<T,ID> extends SimpleJpaRepository<T,ID>
        implements CustomJpaRepository<T,ID>, Serializable {

    private final EntityManager manager;

    public CustomJpaRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.manager = entityManager;
    }

    @Override
    public T refresh(T t) {
        manager.refresh(t);
        return t;
    }

    @Override
    public void detach(T t) {
        manager.refresh(t);
    }

    @Override
    public List<T> buscarPersonalizado(ParametrosBusca<T> parametrosBusca) {
        // Inicialização
        Class<T> tClass = parametrosBusca.getDomainClass();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(tClass);
        Root<T> root = query.from(tClass); // From Restaurante
        var predicates = new ArrayList<Predicate>();

        // Montando a query
        parametrosBusca.criarWhere(predicates,builder,root);

        // Converte o ArrayList para Array
        if (!predicates.isEmpty()){
            query.where(predicates.toArray(new Predicate[0]));
        }

        // Realizando a consulta
        TypedQuery<T> queryTipada = manager.createQuery(query);
        return queryTipada.getResultList();
    }

}
