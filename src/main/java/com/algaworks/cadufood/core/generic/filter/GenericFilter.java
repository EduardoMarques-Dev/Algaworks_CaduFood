package com.algaworks.cadufood.core.generic.filter;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;

public interface GenericFilter<DomainClass> {

    void criarFiltro(ArrayList<Predicate> predicates, CriteriaBuilder builder, Root<DomainClass> root);

}
