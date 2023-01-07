package com.algaworks.cadufood.domain.repository;

import com.algaworks.cadufood.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

    List<Cozinha> findTodasByNomeContaining(String nome);

}
