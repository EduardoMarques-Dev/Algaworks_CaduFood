package com.algaworks.cadufood.domain.model.util.parametrosBusca;

import com.algaworks.cadufood.core.generic.ParametrosBusca;
import com.algaworks.cadufood.domain.model.Restaurante;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Builder;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@Builder
public class RestauranteParametros implements ParametrosBusca<Restaurante> {

    String nome;
    BigDecimal taxaFreteInicial;
    BigDecimal taxaFreteFinal;
    LocalDateTime dataCadastroInicial;
    LocalDateTime dataCadastroFinal;
    LocalDateTime dataAtualizacaoInicial;
    LocalDateTime dataAtualizacaoFinal;
    String enderecoCep;
    String enderecoLogradouro;
    String enderecoNumero;
    String enderecoBairro;
    Long enderecoCidadeId;
    Long cozinhaId;

    @Override
    public void criarWhere(ArrayList<Predicate> predicates, CriteriaBuilder builder, Root<Restaurante> root) {
        if (StringUtils.hasLength(nome)){
            predicates.add(builder.like(root.get("nome"),"%"+ nome +"%"));
        }
        if (taxaFreteInicial != null){
            predicates.add(builder.greaterThanOrEqualTo(root.get("taxaFrete"), taxaFreteInicial));
        }
        if (taxaFreteFinal != null){
            predicates.add(builder.lessThanOrEqualTo(root.get("taxaFrete"), taxaFreteFinal));
        }
        if (dataCadastroInicial != null){
            predicates.add(builder.greaterThanOrEqualTo(root.get("dataCadastro"), dataCadastroInicial));
        }
        if (dataCadastroFinal != null){
            predicates.add(builder.lessThanOrEqualTo(root.get("dataCadastro"), dataCadastroFinal));
        }
        if (dataAtualizacaoInicial != null){
            predicates.add(builder.greaterThanOrEqualTo(root.get("dataAtualizacao"), dataAtualizacaoInicial));
        }
        if (dataAtualizacaoFinal != null){
            predicates.add(builder.lessThanOrEqualTo(root.get("dataAtualizacao"), dataAtualizacaoFinal));
        }
        if (StringUtils.hasLength(enderecoCep)){
            predicates.add(builder.like(root.get("endereco").get("cep"),"%"+ enderecoCep +"%"));
        }
        if (StringUtils.hasLength(enderecoLogradouro)){
            predicates.add(builder.like(root.get("endereco").get("logradouro"),"%"+ enderecoLogradouro +"%"));
        }
        if (StringUtils.hasLength(enderecoNumero)){
            predicates.add(builder.like(root.get("endereco").get("numero"),"%"+ enderecoNumero +"%"));
        }
        if (StringUtils.hasLength(enderecoBairro)){
            predicates.add(builder.like(root.get("endereco").get("bairro"),"%"+ enderecoBairro +"%"));
        }
        if (enderecoCidadeId != null){
            predicates.add(builder.equal(root.get("endereco").get("cidade").get("id"), enderecoCidadeId));
        }
        if (cozinhaId != null){
            predicates.add(builder.equal(root.get("cozinha").get("id"), cozinhaId));
        }
    }

    @Override
    public Class<Restaurante> getDomainClass() {
        return Restaurante.class;
    }
}
