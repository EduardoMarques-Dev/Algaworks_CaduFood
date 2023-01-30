package com.algaworks.cadufood.api.model.mapper;

import com.algaworks.cadufood.api.model.input.FormaPagamentoInput;
import com.algaworks.cadufood.api.model.output.FormaPagamentoOutput;
import com.algaworks.cadufood.core.generic.mapper.MapeadorGenerico;
import com.algaworks.cadufood.domain.model.FormaPagamento;
import org.springframework.stereotype.Component;

@Component
public class FormaPagamentoMapper extends MapeadorGenerico<FormaPagamento, FormaPagamentoInput, FormaPagamentoOutput> {

    public FormaPagamentoMapper() {
        super(FormaPagamento.class, FormaPagamentoInput.class, FormaPagamentoOutput.class);
    }

}
