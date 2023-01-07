package com.algaworks.cadufood.domain.repository;

import com.algaworks.cadufood.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

// CLASSE DE EXEMPLO
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    /*
     * No lugar do PREFIXO Find, pode-se também usar:
     * - read (singleton resource)
     * - get (custom singleton resource)
     * - query (jpql)
     * - stream (collection resource)
     */

    /* ====================================
     *  JPQL
       ==================================== */

    @Query("from Restaurante where nome like %:nome%")
    List<Restaurante> consultarPorNome(String nome);

    /* ====================================
     *  QUERY METHODS
       ==================================== */

    List<Restaurante> findAllByNomeContaining(String nome);

    List<Restaurante> findFirstByNomeContaining(String nome);

    List<Restaurante> findTop2ByNomeContaining(String nome);

    List<Restaurante> findByTaxaFreteBetween(BigDecimal TaxaInicial, BigDecimal TaxaFinal);

    boolean existsByNome(String nome);

    int countByCozinhaId(Long cozinha);
}
