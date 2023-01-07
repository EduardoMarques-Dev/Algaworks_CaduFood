package com.algaworks.cadufood.domain.repository;

import com.algaworks.cadufood.domain.model.Cozinha;
import com.algaworks.cadufood.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    /*
     * No lugar do PREFIXO Find, pode-se também usar:
     * - read (singleton resource)
     * - get (custom singleton resource)
     * - query (jpql)
     * - stream (collection resource)
     */
    List<Restaurante> findAllByNomeContaining(String nome);

    // Retorna somente o primeiro resultado
    List<Restaurante> findFirstByNomeContaining(String nome);

    // Retorna os 2 primeiros resultados.
    List<Restaurante> findTop2ByNomeContaining(String nome);

    List<Restaurante> findByTaxaFreteBetween(BigDecimal TaxaInicial, BigDecimal TaxaFinal);

    boolean existsByNome(String nome);

    int countByCozinhaId(Long cozinha);
}
