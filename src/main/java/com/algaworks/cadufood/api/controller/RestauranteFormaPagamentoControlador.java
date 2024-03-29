package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.api.model.input.FormaPagamentoInput;
import com.algaworks.cadufood.api.model.output.FormaPagamentoOutput;
import com.algaworks.cadufood.core.generic.crud.controller.subresources.ControladorManyToMany;
import com.algaworks.cadufood.domain.model.FormaPagamento;
import com.algaworks.cadufood.domain.model.Restaurante;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/restaurantes/{codigo}/formas-pagamento")
public class RestauranteFormaPagamentoControlador extends ControladorManyToMany<
        Restaurante,
        FormaPagamento,
        FormaPagamentoInput,
        FormaPagamentoOutput> {

    public RestauranteFormaPagamentoControlador() {
        super("formasPagamento");
    }
}
