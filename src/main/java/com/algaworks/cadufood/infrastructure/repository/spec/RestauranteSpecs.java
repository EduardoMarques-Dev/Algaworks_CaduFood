package com.algaworks.cadufood.infrastructure.repository.spec;

import com.algaworks.cadufood.domain.model.Restaurante;
import com.algaworks.cadufood.domain.repository.util.filtros.RestauranteFiltros;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;

public class RestauranteSpecs {

    public static Specification<Restaurante> usandoFiltro(RestauranteFiltros filtro){
        return ((root, query, builder) -> {
            // Get nos subrecursos
           var predicates = new ArrayList<Predicate>();

           filtro.criarFiltro(predicates, builder, root);

           return builder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
