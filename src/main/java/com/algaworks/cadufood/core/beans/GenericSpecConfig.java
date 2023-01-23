package com.algaworks.cadufood.core.beans;

import com.algaworks.cadufood.core.generic.filter.GenericSpec;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenericSpecConfig {

    @Bean
    public GenericSpec genericSpec(){
        return new GenericSpec();
    }
}
