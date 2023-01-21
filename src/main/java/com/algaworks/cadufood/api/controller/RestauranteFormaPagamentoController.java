package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.api.model.input.FormaPagamentoInput;
import com.algaworks.cadufood.api.model.mapper.FormaPagamentoMapper;
import com.algaworks.cadufood.api.model.output.FormaPagamentoOutput;
import com.algaworks.cadufood.core.generic.crud.controller.GenericController;
import com.algaworks.cadufood.domain.model.FormaPagamento;
import com.algaworks.cadufood.domain.model.Restaurante;
import com.algaworks.cadufood.domain.service.FormaPagamentoService;
import com.algaworks.cadufood.domain.service.RestauranteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/restaurantes/{restauranteId}/formas-pagamento")
public class RestauranteFormaPagamentoController {

    @Autowired
    private FormaPagamentoService formaPagamentoService;

    @Autowired
    private RestauranteService restauranteService;

    @Autowired
    private FormaPagamentoMapper mapper;

    @GetMapping
    public List<FormaPagamentoOutput> listar(@PathVariable Long restauranteId) {
        Restaurante restaurante = restauranteService.buscar(restauranteId);
        return mapper.toOutputCollection(restaurante.getFormasPagamento());
    }

    @PostMapping("/{formaPagamentoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void associar(@PathVariable Long restauranteId, @PathVariable Long formaPagamentoId) {
        restauranteService.associarFormaPagamento(restauranteId, formaPagamentoId);
    }

    @DeleteMapping("/{formaPagamentoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desassociar(@PathVariable Long restauranteId, @PathVariable Long formaPagamentoId) {
        restauranteService.desassociarFormaPagamento(restauranteId, formaPagamentoId);
    }

}
