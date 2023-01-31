package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.core.generic.crud.service.ServicoGenerico;
import com.algaworks.cadufood.domain.model.FormaPagamento;
import com.algaworks.cadufood.domain.repository.FormaPagamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class FormaPagamentoService extends ServicoGenerico<FormaPagamento> {

    public FormaPagamentoService(FormaPagamentoRepository repositorio) {
        super(repositorio);
    }
}