package com.algaworks.cadufood.core.generic.crud.controller.subresources;

import com.algaworks.cadufood.core.generic.crud.service.ServicoGenerico;
import com.algaworks.cadufood.core.generic.mapper.MapeadorGenerico;
import com.algaworks.cadufood.core.generic.model.DTO;
import com.algaworks.cadufood.core.generic.model.EntidadeGenerica;
import com.algaworks.cadufood.core.generic.model.EntidadePai;
import com.algaworks.cadufood.core.generic.model.EntidadePaiImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public abstract class ControladorManyToMany<
        FatherModel extends EntidadePai,
        ChildModel extends EntidadeGenerica,
        ChildInputModel extends DTO,
        ChildOutputModel extends DTO> {

    final String subResourceName;

    @Autowired
    protected ServicoGenerico<FatherModel> fatherService;

    @Autowired
    protected ServicoGenerico<ChildModel> childService;

    @Autowired
    protected MapeadorGenerico<ChildModel, ChildInputModel, ChildOutputModel> childMapper;

    @GetMapping
    public List<ChildOutputModel> listarDomainModel(@PathVariable String codigo) {
        FatherModel fatherModel = fatherService.buscar(codigo);
        return childMapper.toOutputCollection((Collection<ChildModel>) fatherModel.listarSubRecurso(subResourceName));
    }

    @GetMapping("/{childCodigo}")
    public List<ChildOutputModel> buscarDomainModel(@PathVariable String codigo, @PathVariable String childCodigo) {
        FatherModel fatherModel = fatherService.buscar(codigo);
        ChildModel childModel = childService.buscar(childCodigo);
        return childMapper.toOutputCollection((Collection<ChildModel>) fatherModel.buscarSubRecurso(subResourceName, childModel));
    }

    @PostMapping("/{childCodigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void associarDomainModel(@PathVariable String codigo, @PathVariable String childCodigo) {
        FatherModel fatherModel = fatherService.buscar(codigo);
        ChildModel childModel = childService.buscar(childCodigo);
        fatherModel.associarSubRecurso(subResourceName, childModel);
    }

    @DeleteMapping("/{childCodigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void DesassociarDomainModel(@PathVariable String codigo, @PathVariable String childCodigo) {
        FatherModel fatherModel = fatherService.buscar(codigo);
        ChildModel childModel = childService.buscar(childCodigo);
        fatherModel.desassociarSubRecurso(subResourceName, childModel);
    }

}
