package com.algaworks.cadufood.infrastructure.repository;

import com.algaworks.cadufood.domain.model.Restaurante;
import com.algaworks.cadufood.domain.repository.queries.RestauranteRepositoryQueries;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;
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
        // Inicialização
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Restaurante> criteria = builder
                .createQuery(Restaurante.class);

        // Montando a query
        criteria.from(Restaurante.class); // From Restaurante


        // Realizando a consulta
        TypedQuery<Restaurante> query = manager.createQuery(criteria);
        return query.getResultList();
    }

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
