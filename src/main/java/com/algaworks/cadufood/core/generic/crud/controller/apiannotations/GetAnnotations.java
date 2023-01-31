package com.algaworks.cadufood.core.generic.crud.controller.apiannotations;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface GetAnnotations<OutputModel>{

    @GetMapping
    List<OutputModel> listar();

    @GetMapping("/{codigo}")
    OutputModel buscar(@PathVariable String codigo);

}
