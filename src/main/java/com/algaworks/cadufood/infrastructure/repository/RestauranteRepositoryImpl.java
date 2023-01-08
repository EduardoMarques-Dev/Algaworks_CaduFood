package com.algaworks.cadufood.infrastructure.repository;

import com.algaworks.cadufood.domain.model.Restaurante;
import com.algaworks.cadufood.domain.repository.util.interfacequeries.RestauranteRepositoryQueries;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

    public List<Restaurante> buscarPersonalizado(String nome,
                                                 BigDecimal taxaFreteInicial,
                                                 BigDecimal taxaFreteFinal,
                                                 Long idCozinha){
        // Inicialização
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Restaurante> query = builder.createQuery(Restaurante.class);
        Root<Restaurante> root = query.from(Restaurante.class); // From Restaurante
        var predicates = new ArrayList<Predicate>();

        // Montando a query
        if (StringUtils.hasLength(nome)){
            predicates.add(builder.like(root.get("nome"),"%"+nome+"%"));
        }
        if (taxaFreteInicial != null){
            predicates.add(builder.greaterThanOrEqualTo(root.get("taxaFrete"),taxaFreteInicial));
        }
        if (taxaFreteFinal != null){
            predicates.add(builder.lessThanOrEqualTo(root.get("taxaFrete"),taxaFreteFinal));
        }
        if (idCozinha != null){
            predicates.add(builder.equal(root.get("cozinha").get("id"), idCozinha));
        }

        // Converte o ArrayList para Array
        query.where(predicates.toArray(new Predicate[0]));

        // Realizando a consulta
        TypedQuery<Restaurante> queryTipada = manager.createQuery(query);
        return queryTipada.getResultList();
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
