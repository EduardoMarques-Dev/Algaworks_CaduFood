package com.algaworks.cadufood.core.generic.filter;

import com.algaworks.cadufood.core.generic.model.EntidadeGenerica;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;

public abstract class GenericSpecification<DomainModel extends EntidadeGenerica> {

    public Specification<DomainModel> usandoFiltro(GenericFilter<DomainModel> genericFilter){
        return ((root, query, builder) -> {
            var predicates = new ArrayList<Predicate>();

            genericFilter.criarFiltro(predicates, builder, root);

            return builder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
