package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.api.model.input.FormaPagamentoInput;
import com.algaworks.cadufood.api.model.mapper.FormaPagamentoMapper;
import com.algaworks.cadufood.api.model.output.FormaPagamentoOutput;
import com.algaworks.cadufood.core.generic.crud.controller.SubResourceController;
import com.algaworks.cadufood.domain.model.FormaPagamento;
import com.algaworks.cadufood.domain.model.Restaurante;
import com.algaworks.cadufood.domain.service.FormaPagamentoService;
import com.algaworks.cadufood.domain.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/restaurantes/{codigo}/formas-pagamento")
public class RestauranteFormaPagamentoController extends SubResourceController<
        Restaurante,
        FormaPagamento,
        FormaPagamentoInput,
        FormaPagamentoOutput> {

    @Autowired
    private RestauranteService restauranteService;

    @Autowired
    private FormaPagamentoService formaPagamentoService;

    @Autowired
    private FormaPagamentoMapper mapper;

    public RestauranteFormaPagamentoController(RestauranteService fatherService, FormaPagamentoService childService, FormaPagamentoMapper childMapper) {
        super("formasPagamento", fatherService, childService, childMapper);
    }

}
