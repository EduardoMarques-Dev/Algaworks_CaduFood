package com.algaworks.cadufood.core.generic.crud;

import com.algaworks.cadufood.core.generic.mapper.GenericMapper;
import com.algaworks.cadufood.core.generic.model.DataTransferObject;
import com.algaworks.cadufood.core.generic.model.GenericEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

public abstract class BasicController<
        DomainModel extends GenericEntity<DomainModel>,
        InputModel extends DataTransferObject<InputModel>,
        OutputModel extends DataTransferObject<OutputModel>> extends GenericController<DomainModel, InputModel, OutputModel>  {

    public BasicController(GenericService<DomainModel> service, GenericMapper<DomainModel, InputModel, OutputModel> mapper) {
        super(service, mapper);
    }

    @Override
    @GetMapping
    public List<OutputModel> listar() {
        return super.listar();
    }

    @Override
    @GetMapping("/{id}")
    public OutputModel buscar(@PathVariable Long id) {
        return super.buscar(id);
    }

    @Override
    @PostMapping
    public OutputModel salvar(@RequestBody @Valid InputModel inputModel) {
        return super.salvar(inputModel);
    }

    @Override
    @PutMapping("/{id}")
    public OutputModel atualizar(@PathVariable Long id, @RequestBody @Valid InputModel inputModel) {
        return super.atualizar(id, inputModel);
    }

    @Override
    @PatchMapping("/{id}")
    public OutputModel atualizarParcial(@PathVariable Long id, @RequestBody HashMap<String, Object> fields) {
        return super.atualizarParcial(id, fields);
    }

    @Override
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        super.excluir(id);
    }
}
