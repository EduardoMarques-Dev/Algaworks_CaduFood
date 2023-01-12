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

//    public List<Restaurante> buscarPersonalizado(String nome,
//                                                 BigDecimal taxaFreteInicial,
//                                                 BigDecimal taxaFreteFinal,
//                                                 LocalDateTime dataCadastroInicial,
//                                                 LocalDateTime dataCadastroFinal,
//                                                 LocalDateTime dataAtualizacaoInicial,
//                                                 LocalDateTime dataAtualizacaoFinal,
//                                                 String enderecoCep,
//                                                 String enderecoLogradouro,
//                                                 String enderecoNumero,
//                                                 String enderecoBairro,
//                                                 Long enderecoCidadeId,
//                                                 Long cozinhaId){
//        // Inicialização
//        CriteriaBuilder builder = manager.getCriteriaBuilder();
//        CriteriaQuery<Restaurante> query = builder.createQuery(Restaurante.class);
//        Root<Restaurante> root = query.from(Restaurante.class); // From Restaurante
//        var predicates = new ArrayList<Predicate>();
//
//        // Montando a query
//        criaWhere(nome, taxaFreteInicial, taxaFreteFinal, dataCadastroInicial, dataCadastroFinal, dataAtualizacaoInicial, dataAtualizacaoFinal, enderecoCep, enderecoLogradouro, enderecoNumero, enderecoBairro, enderecoCidadeId, cozinhaId, builder, root, predicates);
//
//        // Converte o ArrayList para Array
//        if (!predicates.isEmpty()){
//            query.where(predicates.toArray(new Predicate[0]));
//        }
//
//        // Realizando a consulta
//        TypedQuery<Restaurante> queryTipada = manager.createQuery(query);
//        return queryTipada.getResultList();
//    }
//
//    private static void criaWhere(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal, LocalDateTime dataCadastroInicial, LocalDateTime dataCadastroFinal, LocalDateTime dataAtualizacaoInicial, LocalDateTime dataAtualizacaoFinal, String enderecoCep, String enderecoLogradouro, String enderecoNumero, String enderecoBairro, Long enderecoCidadeId, Long cozinhaId, CriteriaBuilder builder, Root<Restaurante> root, ArrayList<Predicate> predicates) {
//        if (StringUtils.hasLength(nome)){
//            predicates.add(builder.like(root.get("nome"),"%"+ nome +"%"));
//        }
//        if (taxaFreteInicial != null){
//            predicates.add(builder.greaterThanOrEqualTo(root.get("taxaFrete"), taxaFreteInicial));
//        }
//        if (taxaFreteFinal != null){
//            predicates.add(builder.lessThanOrEqualTo(root.get("taxaFrete"), taxaFreteFinal));
//        }
//        if (dataCadastroInicial != null){
//            predicates.add(builder.greaterThanOrEqualTo(root.get("dataCadastro"), dataCadastroInicial));
//        }
//        if (dataCadastroFinal != null){
//            predicates.add(builder.lessThanOrEqualTo(root.get("dataCadastro"), dataCadastroFinal));
//        }
//        if (dataAtualizacaoInicial != null){
//            predicates.add(builder.greaterThanOrEqualTo(root.get("dataAtualizacao"), dataAtualizacaoInicial));
//        }
//        if (dataAtualizacaoFinal != null){
//            predicates.add(builder.lessThanOrEqualTo(root.get("dataAtualizacao"), dataAtualizacaoFinal));
//        }
//        if (StringUtils.hasLength(enderecoCep)){
//            predicates.add(builder.like(root.get("endereco").get("cep"),"%"+ enderecoCep +"%"));
//        }
//        if (StringUtils.hasLength(enderecoLogradouro)){
//            predicates.add(builder.like(root.get("endereco").get("logradouro"),"%"+ enderecoLogradouro +"%"));
//        }
//        if (StringUtils.hasLength(enderecoNumero)){
//            predicates.add(builder.like(root.get("endereco").get("numero"),"%"+ enderecoNumero +"%"));
//        }
//        if (StringUtils.hasLength(enderecoBairro)){
//            predicates.add(builder.like(root.get("endereco").get("bairro"),"%"+ enderecoBairro +"%"));
//        }
//        if (enderecoCidadeId != null){
//            predicates.add(builder.equal(root.get("endereco").get("cidade").get("id"), enderecoCidadeId));
//        }
//        if (cozinhaId != null){
//            predicates.add(builder.equal(root.get("cozinha").get("id"), cozinhaId));
//        }
//    }

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
