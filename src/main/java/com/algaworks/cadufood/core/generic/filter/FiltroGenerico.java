package com.algaworks.cadufood.core.generic.filter;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;

/**
 * Interface que representa um filtro genérico.
 *
 * @author Carlos Eduardo Marques Pereira
 */
public interface FiltroGenerico<DomainClass> {

    void criarFiltro(ArrayList<Predicate> predicates, CriteriaBuilder builder, Root<DomainClass> root);

}
