package com.algaworks.cadufood.domain.repository.util.interfacequeries;

import com.algaworks.cadufood.domain.model.Restaurante;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


/*
    Interface criada para manter a integridade entre
    o RestauranteRepository e sua implementação,
    o RestauranteRepositoryImpl
 */
public interface RestauranteRepositoryQueries {

    List<Restaurante> buscarPersonalizado(String nome,
                                          BigDecimal taxaFreteInicial,
                                          BigDecimal taxaFreteFinal,
                                          LocalDateTime dataCadastroInicial,
                                          LocalDateTime dataCadastroFinal,
                                          LocalDateTime dataAtualizacaoInicial,
                                          LocalDateTime dataAtualizacaoFinal,
                                          String enderecoCep,
                                          String enderecoLogradouro,
                                          String enderecoNumero,
                                          String enderecoBairro,
                                          Long enderecoCidadeId,
                                          Long cozinhaId);
}
