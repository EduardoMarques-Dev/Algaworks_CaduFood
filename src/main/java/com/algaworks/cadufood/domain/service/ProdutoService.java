package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.core.generic.crud.service.GenericService;
import com.algaworks.cadufood.domain.exception.NegocioException;
import com.algaworks.cadufood.domain.model.Produto;
import com.algaworks.cadufood.domain.model.Restaurante;
import com.algaworks.cadufood.domain.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService extends GenericService<Produto> {
    private final ProdutoRepository produtoRepository;

    public List<Produto> listarPorRestaurante(Restaurante restaurante) {
        return produtoRepository.findAllByRestaurante(restaurante);
    }

    public Produto buscarPorRestaurante(String restauranteCodigo, String produtoCodigo) {
        return produtoRepository.findByCodigoAndRestaurante(restauranteCodigo, produtoCodigo)
                .orElseThrow( () -> new NegocioException("não deu papai"));
    }

}
