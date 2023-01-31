package com.algaworks.cadufood.core.generic.crud.controller.apiannotations;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

public interface PostPutAnnotations<InputModel, OutputModel> {

    @PostMapping
    OutputModel salvar(@RequestBody @Valid InputModel inputModel);

    @PutMapping("/{codigo}")
    OutputModel atualizar(@PathVariable String codigo, @RequestBody @Valid InputModel inputModel);

    @PatchMapping("/{codigo}")
    OutputModel atualizarParcial(@PathVariable String codigo, @RequestBody HashMap<String, Object> fields);

}
