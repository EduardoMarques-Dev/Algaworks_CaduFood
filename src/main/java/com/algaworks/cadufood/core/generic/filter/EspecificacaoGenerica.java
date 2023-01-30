package com.algaworks.cadufood.core.generic.filter;

import com.algaworks.cadufood.core.generic.model.EntidadeGenerica;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;

/**
 * Interface que representa uma especificação genérica.
 *
 * @author Carlos Eduardo Marques Pereira
 */
public abstract class EspecificacaoGenerica<DomainModel extends EntidadeGenerica> {

    public Specification<DomainModel> usandoFiltro(FiltroGenerico<DomainModel> filtroGenerico){
        return ((root, query, builder) -> {
            var predicates = new ArrayList<Predicate>();

            filtroGenerico.criarFiltro(predicates, builder, root);

            return builder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
