package com.algaworks.cadufood.domain.repository.queries;

import com.algaworks.cadufood.domain.model.Restaurante;

import java.math.BigDecimal;
import java.util.List;


/*
    Interface criada para manter a integridade entre
    o RestauranteRepository e sua implementação,
    o RestauranteRepositoryImpl
 */
public interface RestauranteRepositoryQueries {

    List<Restaurante> buscarCustomizado(String nome,
                                        BigDecimal taxaFreteInicial,
                                        BigDecimal taxaFreteFinal,
                                        Long idCozinha);
}
