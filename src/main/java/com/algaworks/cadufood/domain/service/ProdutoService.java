package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.core.generic.crud.service.ServicoGenerico;
import com.algaworks.cadufood.domain.exception.NegocioException;
import com.algaworks.cadufood.domain.model.Produto;
import com.algaworks.cadufood.domain.model.Restaurante;
import com.algaworks.cadufood.domain.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService extends ServicoGenerico<Produto> {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository repositorio) {
        super(repositorio);
        this.produtoRepository = repositorio;
    }

    public List<Produto> listarPorRestaurante(Restaurante restaurante) {
        return produtoRepository.findAllByRestaurante(restaurante);
    }

    public Produto buscarPorRestaurante(String restauranteCodigo, String produtoCodigo) {
        return produtoRepository.findByCodigoAndRestaurante(restauranteCodigo, produtoCodigo)
                .orElseThrow( () -> new NegocioException("não deu papai"));
    }

}
