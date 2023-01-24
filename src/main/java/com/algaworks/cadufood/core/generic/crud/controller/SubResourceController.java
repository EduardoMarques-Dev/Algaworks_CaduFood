package com.algaworks.cadufood.core.generic.crud.controller;

import com.algaworks.cadufood.core.generic.crud.service.GenericService;
import com.algaworks.cadufood.core.generic.mapper.GenericMapper;
import com.algaworks.cadufood.core.generic.model.DataTransferObject;
import com.algaworks.cadufood.core.generic.model.FatherEntity;
import com.algaworks.cadufood.core.generic.model.GenericEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public abstract class SubResourceController<
        FatherModel extends FatherEntity,
        ChildModel extends GenericEntity,
        ChildInputModel extends DataTransferObject,
        ChildOutputModel extends DataTransferObject> {

    final String nomeSubRecurso;

    @Autowired
    protected GenericService<FatherModel> fatherService;

    @Autowired
    protected GenericService<ChildModel> childService;

    @Autowired
    protected GenericMapper<ChildModel, ChildInputModel, ChildOutputModel> childMapper;

    @GetMapping
    public List<ChildOutputModel> listarDomainModel(@PathVariable String codigo) {
        FatherModel fatherModel = fatherService.buscar(codigo);
        return childMapper.toOutputCollection((Collection<ChildModel>) fatherModel.listarSubRecurso(nomeSubRecurso));
    }

    @GetMapping("/{childCodigo}")
    public List<ChildOutputModel> buscarDomainModel(@PathVariable String codigo, @PathVariable String childCodigo) {
        FatherModel fatherModel = fatherService.buscar(codigo);
        ChildModel childModel = childService.buscar(childCodigo);
        return childMapper.toOutputCollection((Collection<ChildModel>) fatherModel.buscarSubRecurso(nomeSubRecurso, childModel));
    }

    @PostMapping("/{childCodigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void associarDomainModel(@PathVariable String codigo, @PathVariable String childCodigo) {
        FatherModel fatherModel = fatherService.buscar(codigo);
        ChildModel childModel = childService.buscar(childCodigo);
        fatherModel.associarSubRecurso(nomeSubRecurso, childModel);
    }

    @DeleteMapping("/{childCodigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void DesassociarDomainModel(@PathVariable String codigo, @PathVariable String childCodigo) {
        FatherModel fatherModel = fatherService.buscar(codigo);
        ChildModel childModel = childService.buscar(childCodigo);
        fatherModel.desassociarSubRecurso(nomeSubRecurso, childModel);
    }

}
