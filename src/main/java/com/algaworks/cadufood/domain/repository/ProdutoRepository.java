package com.algaworks.cadufood.domain.repository;

import com.algaworks.cadufood.core.generic.crud.repository.GenericRepository;
import com.algaworks.cadufood.domain.model.Produto;
import com.algaworks.cadufood.domain.model.Restaurante;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends GenericRepository<Produto, Long> {

    @Query("from Produto p where p.restaurante.codigo = :restaurante and p.codigo = :produto")
    Optional<Produto> findByCodigoAndRestaurante(@Param("restaurante") String restauranteCodigo,
                                                   @Param("produto") String produtoCodigo);

    List<Produto> findAllByRestaurante(Restaurante restaurante);

}
