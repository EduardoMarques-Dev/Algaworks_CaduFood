package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.api.model.input.ProdutoInput;
import com.algaworks.cadufood.api.model.output.ProdutoOutput;
import com.algaworks.cadufood.core.generic.crud.controller.SubResourceController;
import com.algaworks.cadufood.domain.model.Produto;
import com.algaworks.cadufood.domain.model.Restaurante;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/restaurantes/{codigo}/produtos")
public class RestauranteProdutoController extends SubResourceController<
        Restaurante,
        Produto,
        ProdutoInput,
        ProdutoOutput> {

    public RestauranteProdutoController() {
        super("produto");
    }

}
