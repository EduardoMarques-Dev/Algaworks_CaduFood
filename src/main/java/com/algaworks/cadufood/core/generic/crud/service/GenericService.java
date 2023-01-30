package com.algaworks.cadufood.core.generic.crud.service;

import com.algaworks.cadufood.core.generic.crud.repository.GenericRepository;
import com.algaworks.cadufood.core.generic.model.EntidadeGenerica;
import com.algaworks.cadufood.domain.exception.EntidadeEmUsoException;
import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.exception.NegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Class representing a generic REST service.
 *
 * @author Carlos Eduardo Marques Pereira
 */
public abstract class GenericService<DomainModel extends EntidadeGenerica> {

    @Autowired
    protected GenericRepository<DomainModel, Long> repository;

//    @Autowired
//    protected GenericSpecification<DomainModel> genericSpecification;

    public List<DomainModel> list() {
        return repository.findAll();
    }

    public DomainModel find(String domainModelCodigo) {
        return findOrFail(domainModelCodigo);
    }

//    public Page<DomainModel> buscarPersonalizado(GenericFilter<DomainModel> genericFilter, Pageable pageable) {
//        return repository.findAll(genericSpecification.usandoFiltro(genericFilter), pageable);
//    }

    @Transactional
    public DomainModel save(DomainModel domainModel) {
        try {
            return saveAndRefresh(domainModel);
        } catch (DataIntegrityViolationException ex){
            throw new NegocioException(ex);
        }
    }

    @Transactional
    public void delete(String domainModelCodigo) {
        try{
            repository.deleteByCodigo(domainModelCodigo);
            repository.flush();
        } catch (EmptyResultDataAccessException ex){
            throw new EntidadeNaoEncontradaException(domainModelCodigo);
        } catch (DataIntegrityViolationException ex){
            throw new EntidadeEmUsoException();
        }
    }

    private DomainModel findOrFail(String domainModelCodigo) {
        return repository.findByCodigo(domainModelCodigo).orElseThrow(() -> new EntidadeNaoEncontradaException(
                domainModelCodigo
        ));
    }

    @Transactional
    private DomainModel saveAndRefresh(DomainModel domainModel) {
        return refresh(repository.save(domainModel));
    }

    @Transactional
    public DomainModel refresh(DomainModel domainModel) {
        repository.flush();
        return repository.refresh(domainModel);
    }

}