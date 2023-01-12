package com.algaworks.cadufood.domain.repository;

import com.algaworks.cadufood.core.generic.crud.CustomJpaRepository;
import com.algaworks.cadufood.domain.model.Restaurante;
import com.algaworks.cadufood.domain.repository.util.interfacequeries.RestauranteRepositoryQueries;
import org.springframework.stereotype.Repository;

// CLASSE DE EXEMPLO
@Repository
public interface RestauranteRepository extends
        CustomJpaRepository<Restaurante, Long>,
        RestauranteRepositoryQueries {

}




























/*
 * No lugar do PREFIXO Find, pode-se também usar:
 * - read (singleton resource)
 * - get (custom singleton resource)
 * - query (jpql)
 * - stream (collection resource)
 */

/* ====================================
 *  JPQL
 * ==================================== */

//    @Query("from Restaurante where nome like %:nome%")
//    List<Restaurante> buscarPorNome(String nome);
//
//    /* ====================================
//     *  QUERY METHODS
//     * ==================================== */
//
//    List<Restaurante> findAllByNomeContaining(String nome);
//
//    List<Restaurante> findFirstByNomeContaining(String nome);
//
//    List<Restaurante> findTop2ByNomeContaining(String nome);
//
//    List<Restaurante> findByTaxaFreteBetween(BigDecimal TaxaInicial, BigDecimal TaxaFinal);
//
//    boolean existsByNome(String nome);
//
//    int countByCozinhaId(Long cozinha);

/* ====================================
 *  IMPLEMENTED METHODS
 * ==================================== */

//    // Como a classe está extendendo a interface que possui esse método, ele não precisa mais ser declarado aqui
//     List<Restaurante> buscarPorNomeEFrete(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);
