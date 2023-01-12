package com.algaworks.cadufood.infrastructure.repository;

import com.algaworks.cadufood.domain.repository.util.interfacequeries.RestauranteRepositoryQueries;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/*
 * Para criar qualquer implementação de um repositório
 * basta criar uma classe com o sufixo "Impl" e
 * fazê-la implementar o repositório desejado
 * que o Spring já conecta ambas automaticamente
 */
@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {

    @PersistenceContext
    private EntityManager manager;

//    public List<Restaurante> buscarPorNomeEFrete(String nome,
//                                                 BigDecimal taxaFreteInicial,
//                                                 BigDecimal taxaFreteFinal){
//        // Responsável por montar a query
//        var jpql = new StringBuilder();
//        // Responsável por atribuir os parâmetros
//        var parametros = new HashMap<String, Object>();
//
//        jpql.append("from Restaurante where 0=0 ");
//        if (StringUtils.hasLength(nome)){
//            jpql.append("and nome like :nome ");
//            parametros.put("nome", "%" + nome + "%");
//        }
//        if (taxaFreteInicial != null){
//            jpql.append("and taxaFrete >= :taxaInicial ");
//            parametros.put("taxaInicial", taxaFreteInicial);
//        }
//        if (taxaFreteFinal != null){
//            jpql.append("and taxaFrete <= :taxaFinal ");
//            parametros.put("taxaFinal", taxaFreteFinal);
//        }
//
//        // Responsável por criar a consulta
//        TypedQuery<Restaurante> query = manager.createQuery(jpql.toString(), Restaurante.class);
//        parametros.forEach((chave, valor) -> query.setParameter(chave,valor));
//        return query.getResultList();
//    }

}
