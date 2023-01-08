package com.algaworks.cadufood;

import com.algaworks.cadufood.infrastructure.repository.CustomJpaRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class CadufoodApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadufoodApiApplication.class, args);
	}

}
