package com.algaworks.cadufood.core.generic.crud.controller.apiannotations;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface DeleteAnnotations {

    @DeleteMapping("/{codigo}")
    void excluir(@PathVariable String codigo);

}
