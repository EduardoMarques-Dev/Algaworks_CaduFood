package com.algaworks.cadufood.core.generic.crud.controller;

import com.algaworks.cadufood.core.generic.crud.service.ServicoConsultasAvancadas;
import com.algaworks.cadufood.core.generic.filter.FiltroGenerico;
import com.algaworks.cadufood.core.generic.mapper.MapeadorGenerico;
import com.algaworks.cadufood.core.generic.model.EntidadeGenerica;
import com.algaworks.cadufood.core.generic.model.ObjetoGenerico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;

public abstract class ControladorConsultasAvancadas<
        DomainModel extends EntidadeGenerica,
        InputModel extends ObjetoGenerico,
        OutputModel extends ObjetoGenerico,
        GenericFilter extends FiltroGenerico<DomainModel>>
        extends ControladorExcetoGet<DomainModel, InputModel, OutputModel>{

    protected final ServicoConsultasAvancadas<DomainModel, GenericFilter> servico;

    protected final MapeadorGenerico<DomainModel, InputModel, OutputModel> mapper;

    public ControladorConsultasAvancadas(ServicoConsultasAvancadas<DomainModel, GenericFilter> servico, MapeadorGenerico<DomainModel, InputModel, OutputModel> mapper) {
        super(servico, mapper);
        this.servico = servico;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<OutputModel> buscarPersonalizado(GenericFilter genericFilter,
                                                 @PageableDefault(size = 10) Pageable pageable) {
        Page<DomainModel> domainModels = servico.buscarPersonalizado(genericFilter, pageable);
        return mapper.toOutputCollection(domainModels);
    }

}
