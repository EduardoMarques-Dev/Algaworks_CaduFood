package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.api.model.input.FormaPagamentoInput;
import com.algaworks.cadufood.api.model.mapper.FormaPagamentoMapper;
import com.algaworks.cadufood.api.model.output.FormaPagamentoOutput;
import com.algaworks.cadufood.core.generic.crud.GenericController;
import com.algaworks.cadufood.domain.model.FormaPagamento;
import com.algaworks.cadufood.domain.service.FormaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/formas-pagamento")
public class FormaPagamentoController  extends GenericController<FormaPagamento, FormaPagamentoInput, FormaPagamentoOutput> {

    @Autowired
    private FormaPagamentoService formaPagamentoService;

    @Autowired
    private FormaPagamentoMapper mapper;

    public FormaPagamentoController(FormaPagamentoService service, FormaPagamentoMapper mapper) {
        super(service, mapper);
    }
}
