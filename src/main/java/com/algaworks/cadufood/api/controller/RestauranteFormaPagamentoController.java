package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.api.model.input.FormaPagamentoInput;
import com.algaworks.cadufood.api.model.mapper.FormaPagamentoMapper;
import com.algaworks.cadufood.api.model.output.FormaPagamentoOutput;
import com.algaworks.cadufood.core.generic.crud.controller.FatherController;
import com.algaworks.cadufood.core.generic.crud.service.GenericService;
import com.algaworks.cadufood.core.generic.mapper.GenericMapper;
import com.algaworks.cadufood.domain.model.FormaPagamento;
import com.algaworks.cadufood.domain.model.Restaurante;
import com.algaworks.cadufood.domain.service.FormaPagamentoService;
import com.algaworks.cadufood.domain.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/restaurantes/{fatherResourceCodigo}/formas-pagamento")
public class RestauranteFormaPagamentoController extends FatherController<
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
        super(FormaPagamento.class, fatherService, childService, childMapper);
    }

//    @GetMapping
//    public List<FormaPagamentoOutput> listarFormaPagamento(@PathVariable String restauranteCodigo) {
//        Restaurante restaurante = restauranteService.buscar(restauranteCodigo);
//        return mapper.toOutputCollection((Collection<FormaPagamento>) restaurante.getSubRecurso("formasPagamento"));
//    }
//
//    @GetMapping("/{formaPagamentoCodigo}")
//    public List<FormaPagamentoOutput> buscarFormaPagamento(@PathVariable String restauranteCodigo, @PathVariable String formaPagamentoCodigo) {
//        Restaurante restaurante = restauranteService.buscar(restauranteCodigo);
//        FormaPagamento formaPagamento = formaPagamentoService.buscar(formaPagamentoCodigo);
//        return mapper.toOutputCollection(restaurante.getFormaPagamento(formaPagamento));
//    }
//
//    @PostMapping("/{formaPagamentoCodigo}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void associarFormaPagamento(@PathVariable String restauranteCodigo, @PathVariable String formaPagamentoCodigo) {
//        restauranteService.associarFormaPagamento(restauranteCodigo, formaPagamentoCodigo);
//    }
//
//    @DeleteMapping("/{formaPagamentoCodigo}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void DesassociarFormaPagamento(@PathVariable String restauranteCodigo, @PathVariable String formaPagamentoCodigo) {
//        restauranteService.desassociarFormaPagamento(restauranteCodigo, formaPagamentoCodigo);
//    }

}
