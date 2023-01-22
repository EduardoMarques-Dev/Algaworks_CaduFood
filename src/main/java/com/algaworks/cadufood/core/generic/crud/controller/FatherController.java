package com.algaworks.cadufood.core.generic.crud.controller;

import com.algaworks.cadufood.core.generic.crud.service.GenericService;
import com.algaworks.cadufood.core.generic.mapper.GenericMapper;
import com.algaworks.cadufood.core.generic.model.DataTransferObject;
import com.algaworks.cadufood.core.generic.model.FatherEntity;
import com.algaworks.cadufood.core.generic.model.GenericEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
public abstract class FatherController<
        FatherModel extends FatherEntity<FatherModel>,
        ChildModel extends GenericEntity<ChildModel>,
        ChildInputModel extends DataTransferObject<ChildInputModel>,
        ChildOutputModel extends DataTransferObject<ChildOutputModel>> {

    private final GenericService<FatherModel> fatherService;

    private final GenericService<ChildModel> childService;

    private final GenericMapper<ChildModel, ChildInputModel, ChildOutputModel> childMapper;

//    @GetMapping
//    public List<ChildOutputModel> listarDomainModel(@PathVariable String fatherResourceCodigo) {
//        FatherModel fatherModel = fatherService.buscar(fatherResourceCodigo);
//        return childMapper.toOutputCollection(fatherModel.listarSubRecurso(ChildModel));
//    }
//
//    @GetMapping("/{formaPagamentoCodigo}")
//    public List<ChildOutputModel> buscarDomainModel(@PathVariable String fatherResourceCodigo, @PathVariable String formaPagamentoCodigo) {
//        FatherModel fatherModel = fatherService.buscar(fatherResourceCodigo);
//        ChildModel formaPagamento = childService.buscar(formaPagamentoCodigo);
//        return childMapper.toOutputCollection(fatherModel.getDomainModel(formaPagamento));
//    }
//
//    @PostMapping("/{formaPagamentoCodigo}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void associarDomainModel(@PathVariable String fatherResourceCodigo, @PathVariable String formaPagamentoCodigo) {
//        fatherService.associarDomainModel(fatherResourceCodigo, formaPagamentoCodigo);
//    }
//
//    @DeleteMapping("/{formaPagamentoCodigo}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void DesassociarDomainModel(@PathVariable String fatherResourceCodigo, @PathVariable String formaPagamentoCodigo) {
//        fatherService.desassociarDomainModel(fatherResourceCodigo, formaPagamentoCodigo);
//    }

}
