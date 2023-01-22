package com.algaworks.cadufood.core.generic.crud.controller;

import com.algaworks.cadufood.core.generic.crud.service.GenericService;
import com.algaworks.cadufood.core.generic.mapper.GenericMapper;
import com.algaworks.cadufood.core.generic.model.DataTransferObject;
import com.algaworks.cadufood.core.generic.model.FatherEntity;
import com.algaworks.cadufood.core.generic.model.GenericEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public abstract class FatherController<
        FatherModel extends FatherEntity<FatherModel>,
        ChildModel extends GenericEntity<ChildModel>,
        ChildInputModel extends DataTransferObject<ChildInputModel>,
        ChildOutputModel extends DataTransferObject<ChildOutputModel>> {

    Class<ChildModel> childModelClass;

    private final GenericService<FatherModel> fatherService;

    private final GenericService<ChildModel> childService;

    private final GenericMapper<ChildModel, ChildInputModel, ChildOutputModel> childMapper;

    @GetMapping
    public List<ChildOutputModel> listarDomainModel(@PathVariable String fatherResourceCodigo) {
        FatherModel fatherModel = fatherService.buscar(fatherResourceCodigo);
        return childMapper.toOutputCollection((Collection<ChildModel>) fatherModel.listarSubRecurso(childModelClass));
    }

    @GetMapping("/{formaPagamentoCodigo}")
    public List<ChildOutputModel> buscarDomainModel(@PathVariable String fatherResourceCodigo, @PathVariable String formaPagamentoCodigo) {
        FatherModel fatherModel = fatherService.buscar(fatherResourceCodigo);
        ChildModel childModel = childService.buscar(formaPagamentoCodigo);
        return childMapper.toOutputCollection((Collection<ChildModel>) fatherModel.buscarSubRecurso(childModel));
    }

    @PostMapping("/{formaPagamentoCodigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void associarDomainModel(@PathVariable String fatherResourceCodigo, @PathVariable String formaPagamentoCodigo) {
        FatherModel fatherModel = fatherService.buscar(fatherResourceCodigo);
        ChildModel childModel = childService.buscar(formaPagamentoCodigo);
        fatherModel.associarSubRecurso(childModel);
    }

    @DeleteMapping("/{formaPagamentoCodigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void DesassociarDomainModel(@PathVariable String fatherResourceCodigo, @PathVariable String formaPagamentoCodigo) {
        FatherModel fatherModel = fatherService.buscar(fatherResourceCodigo);
        ChildModel childModel = childService.buscar(formaPagamentoCodigo);
        fatherModel.desassociarSubRecurso(childModel);
    }

}
