package com.algaworks.cadufood.core.beans;

import com.algaworks.cadufood.core.generic.filter.GenericFilter;
import com.algaworks.cadufood.core.generic.filter.GenericSpecification;
import com.algaworks.cadufood.core.generic.model.GenericEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class GenericsConfig {

    @Bean
    public GenericSpecification<?> genericSpec(){
        return new EspecificacaoGenerica();
    }

    static class EspecificacaoGenerica extends GenericSpecification<ObjetoGenerico> {
    }

    static class ObjetoGenerico implements GenericEntity {
        @Override
        public Long getId() {
            return null;
        }
        @Override
        public String getCodigo() {
            return null;
        }
        @Override
        public void setCodigo(String codigo) {

        }
        @Override
        public String getNome() {
            return null;
        }
    }

    static class ObjetoGenericoFiltro implements GenericFilter<ObjetoGenerico>{
        @Override
        public void criarFiltro(ArrayList<Predicate> predicates, CriteriaBuilder builder, Root<ObjetoGenerico> root) {
        }
    }
}
