package com.algaworks.cadufood.domain.repository.util.interfacequeries;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;

public interface ParametrosBusca<DomainClass> {

    void criarWhere(ArrayList<Predicate> predicates, CriteriaBuilder builder, Root<DomainClass> root);

    Class<DomainClass> getDomainClass();
}
