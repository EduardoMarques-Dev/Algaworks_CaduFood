package com.algaworks.cadufood.domain.repository;

import com.algaworks.cadufood.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    List<Restaurante> findByTaxaFreteBetween(BigDecimal TaxaInicial, BigDecimal TaxaFinal);

}
