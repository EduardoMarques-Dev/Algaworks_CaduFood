package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.api.model.input.CidadeInput;
import com.algaworks.cadufood.api.model.mapper.CidadeMapper;
import com.algaworks.cadufood.api.model.output.CidadeOutput;
import com.algaworks.cadufood.core.generic.crud.controller.ExceptGetController;
import com.algaworks.cadufood.domain.model.Cidade;
import com.algaworks.cadufood.domain.service.CidadeService;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController extends ExceptGetController<Cidade, CidadeInput, CidadeOutput> {

    @Autowired
    private CidadeService cidadeService;

    @Autowired
    private CidadeMapper mapper;

    @GetMapping
    public MappingJacksonValue list(@RequestParam(required = false) String campos) {
        List<CidadeOutput> outputModels = mapper.toOutputCollection(cidadeService.list());

        MappingJacksonValue outputWrapper = new MappingJacksonValue(outputModels);
        outputWrapper.setFilters(adicionarFiltros(campos));

        return outputWrapper;
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

    @Override
    public CidadeOutput find(String code) {
        return super.find(code);
    }
}
