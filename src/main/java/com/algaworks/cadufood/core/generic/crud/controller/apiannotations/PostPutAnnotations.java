package com.algaworks.cadufood.core.generic.crud.controller.apiannotations;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

public interface PostPutAnnotations<InputModel, OutputModel> {

    @PostMapping
    public OutputModel salvar(@RequestBody @Valid InputModel inputModel);

    @PutMapping("/{id}")
    public OutputModel atualizar(@PathVariable Long id, @RequestBody @Valid InputModel inputModel);

    @PatchMapping("/{id}")
    public OutputModel atualizarParcial(@PathVariable Long id, @RequestBody HashMap<String, Object> fields);

}
