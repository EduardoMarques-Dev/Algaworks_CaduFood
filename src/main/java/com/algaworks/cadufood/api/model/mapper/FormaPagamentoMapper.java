package com.algaworks.cadufood.api.model.mapper;

import com.algaworks.cadufood.api.model.input.FormaPagamentoInput;
import com.algaworks.cadufood.api.model.output.FormaPagamentoOutput;
import com.algaworks.cadufood.core.generic.mapper.GenericMapper;
import com.algaworks.cadufood.domain.model.FormaPagamento;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class FormaPagamentoMapper implements GenericMapper<FormaPagamento, FormaPagamentoInput, FormaPagamentoOutput> {

    private ModelMapper modelMapper;

    @Override
    public FormaPagamento toDomain(FormaPagamentoInput formaPagamentoInput) {
        return modelMapper.map(formaPagamentoInput, FormaPagamento.class);
    }

    @Override
    public FormaPagamentoOutput toOutput(FormaPagamento formaPagamento) {
        return modelMapper.map(formaPagamento, FormaPagamentoOutput.class);
    }

    @Override
    public List<FormaPagamento> toDomainCollection(List<FormaPagamentoInput> formaPagamentoInputs) {
        return formaPagamentoInputs.stream()
                .map(dto -> toDomain(dto))
                .collect(Collectors.toList());
    }

    @Override
    public List<FormaPagamentoOutput> toOutputCollection(List<FormaPagamento> formaPagamentos) {
        return formaPagamentos.stream()
                .map(entity -> toOutput(entity))
                .collect(Collectors.toList());
    }

    @Override
    public Page<FormaPagamentoOutput> toOutputCollection(Page<FormaPagamento> formaPagamentos) {
        return new PageImpl<>(toOutputCollection(formaPagamentos.toList()));
    }

    @Override
    public void updateEntity(FormaPagamentoInput newEntity, FormaPagamento currentEntity) {
        modelMapper.map(newEntity, currentEntity);
    }

    @Override
    public void patchEntity(HashMap<String, Object> fields, FormaPagamento currentEntity) {
        modelMapper.map(fields, currentEntity);
    }
}
