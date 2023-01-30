package com.algaworks.cadufood.core.generic.crud.controller.apiannotations;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

public interface PostPutAnnotations<InputModel, OutputModel> {

    @PostMapping
    public OutputModel save(@RequestBody @Valid InputModel inputModel);

    @PutMapping("/{codigo}")
    public OutputModel update(@PathVariable String codigo, @RequestBody @Valid InputModel inputModel);

    @PatchMapping("/{codigo}")
    public OutputModel patch(@PathVariable String codigo, @RequestBody HashMap<String, Object> fields);

}
