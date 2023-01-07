package com.algaworks.cadufood.infrastructure.repository;

import com.algaworks.cadufood.domain.model.Restaurante;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/*
* Esta classe implementa o repositório de mesmo nome automaticamente
* por ter o sufixo "Impl"
*/
@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {

    @PersistenceContext
    private EntityManager manager;

    public List<Restaurante> buscarPorNomeEFrete(String nome,
                                                 BigDecimal taxaFreteInicial,
                                                 BigDecimal taxaFreteFinal){
        var jpql = "from Restaurante where nome like :nome "
                + "and taxaFrete between :taxaInicial and :taxaFinal";

        return manager.createQuery(jpql, Restaurante.class)
                .setParameter("nome","%" + nome + "%")
                .setParameter("taxaInicial", taxaFreteInicial)
                .setParameter("taxaFinal",taxaFreteFinal)
                .getResultList();
    }

}
