package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.api.model.input.CidadeInput;
import com.algaworks.cadufood.api.model.mapper.CidadeMapper;
import com.algaworks.cadufood.api.model.output.CidadeOutput;
import com.algaworks.cadufood.core.generic.crud.controller.ControladorExcetoGet;
import com.algaworks.cadufood.domain.model.Cidade;
import com.algaworks.cadufood.domain.service.CidadeService;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController extends ControladorExcetoGet<Cidade, CidadeInput, CidadeOutput> {

    private final CidadeService cidadeService;

    private final CidadeMapper mapper;

    @Autowired
    public CidadeController(CidadeService servico, CidadeMapper mapper) {
        super(servico, mapper);
        this.cidadeService = servico;
        this.mapper = mapper;
    }

    @GetMapping
    public MappingJacksonValue listar(@RequestParam(required = false) String campos) {
        List<CidadeOutput> outputModels = mapper.toOutputCollection(cidadeService.listar());

        MappingJacksonValue outputWrapper = new MappingJacksonValue(outputModels);
        outputWrapper.setFilters(adicionarFiltros(campos));

        return outputWrapper;
    }

    @Override
    @GetMapping("/{codigo}")
    public CidadeOutput buscar(@PathVariable String codigo) {
        return super.buscar(codigo);
    }

    private static SimpleFilterProvider adicionarFiltros(String campos) {
        SimpleFilterProvider filterProvider = new SimpleFilterProvider();

        if(StringUtils.isNotBlank(campos)){
            filterProvider.addFilter("CidadeOutput", SimpleBeanPropertyFilter.filterOutAllExcept(campos.split(",")));
        } else {
            filterProvider.addFilter("CidadeOutput", SimpleBeanPropertyFilter.serializeAll());
        }

        return filterProvider;
    }
}
