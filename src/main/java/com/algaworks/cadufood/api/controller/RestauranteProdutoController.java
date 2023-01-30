package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.api.model.input.ProdutoInput;
import com.algaworks.cadufood.api.model.mapper.ProdutoMapper;
import com.algaworks.cadufood.api.model.output.ProdutoOutput;
import com.algaworks.cadufood.domain.model.Produto;
import com.algaworks.cadufood.domain.model.Restaurante;
import com.algaworks.cadufood.domain.service.ProdutoService;
import com.algaworks.cadufood.domain.service.RestauranteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/restaurantes/{restauranteCodigo}/produtos")
public class RestauranteProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private RestauranteService restauranteService;

    @Autowired
    private ProdutoMapper produtoMapper;

    @GetMapping
    public List<ProdutoOutput> listar(@PathVariable String restauranteCodigo) {
        Restaurante restaurante = restauranteService.find(restauranteCodigo);

        List<Produto> todosProdutos = produtoService.listarPorRestaurante(restaurante);

        return produtoMapper.toOutputCollection(todosProdutos);
    }

    @GetMapping("/{produtoCodigo}")
    public ProdutoOutput buscar(@PathVariable String restauranteCodigo, @PathVariable String produtoCodigo) {
        Produto produto = produtoService.buscarPorRestaurante(restauranteCodigo, produtoCodigo);

        return produtoMapper.toOutput(produto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoOutput adicionar(@PathVariable String restauranteCodigo,
                                   @RequestBody @Valid ProdutoInput produtoInput) {
        Restaurante restaurante = restauranteService.find(restauranteCodigo);

        Produto produto = produtoMapper.toDomain(produtoInput);
        produto.setRestaurante(restaurante);

        produto = produtoService.save(produto);

        return produtoMapper.toOutput(produto);
    }

    @PutMapping("/{produtoCodigo}")
    public ProdutoOutput atualizar(@PathVariable String restauranteCodigo, @PathVariable String produtoCodigo,
                                   @RequestBody @Valid ProdutoInput produtoInput) {
        Produto produtoAtual = produtoService.buscarPorRestaurante(restauranteCodigo, produtoCodigo);

        produtoMapper.updateEntity(produtoInput, produtoAtual);

        produtoAtual = produtoService.save(produtoAtual);

        return produtoMapper.toOutput(produtoAtual);
    }

}
