package com.algaworks.cadufood.core.beans;

import com.algaworks.cadufood.core.generic.filter.GenericSpec;
import com.algaworks.cadufood.core.generic.model.GenericEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenericsConfig {

    @Bean
    public GenericSpec<?> genericSpec(){
        return new EspecificacaoGenerica();
    }

    static class EspecificacaoGenerica extends GenericSpec<ObjetoGenerico>{

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
}
