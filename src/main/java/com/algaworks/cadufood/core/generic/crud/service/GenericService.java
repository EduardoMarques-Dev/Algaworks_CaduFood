package com.algaworks.cadufood.core.generic.crud.service;

import com.algaworks.cadufood.core.generic.crud.repository.GenericRepository;
import com.algaworks.cadufood.core.generic.filter.GenericFilter;
import com.algaworks.cadufood.core.generic.filter.GenericSpecification;
import com.algaworks.cadufood.core.generic.model.GenericEntity;
import com.algaworks.cadufood.domain.exception.EntidadeEmUsoException;
import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.exception.NegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public abstract class GenericService<DomainModel extends GenericEntity> {

    @Autowired
    protected GenericRepository<DomainModel, Long> repository;

    @Autowired
    protected GenericSpecification<DomainModel> genericSpecification;

    public List<DomainModel> listar() {
        return repository.findAll();
    }

    public DomainModel buscar(String domainModelCodigo) {
        return buscarDomainModelOuFalhar(domainModelCodigo);
    }

    public Page<DomainModel> buscarPersonalizado(GenericFilter<DomainModel> genericFilter, Pageable pageable) {
        return repository.findAll(genericSpecification.usandoFiltro(genericFilter), pageable);
    }

    @Transactional
    public DomainModel salvar(DomainModel domainModel) {
        try {
            return salvarERecarregar(domainModel);
        } catch (DataIntegrityViolationException ex){
            throw new NegocioException(ex);
        }
    }

    @Transactional
    public void excluir(String domainModelCodigo) {
        try{
            repository.deleteByCodigo(domainModelCodigo);
            repository.flush();
        } catch (EmptyResultDataAccessException ex){
            throw new EntidadeNaoEncontradaException(domainModelCodigo);
        } catch (DataIntegrityViolationException ex){
            throw new EntidadeEmUsoException();
        }
    }

    private DomainModel buscarDomainModelOuFalhar(String domainModelCodigo) {
        return repository.findByCodigo(domainModelCodigo).orElseThrow(() -> new EntidadeNaoEncontradaException(
                domainModelCodigo
        ));
    }

    @Transactional
    private DomainModel salvarERecarregar(DomainModel domainModel) {
        return recarregar(repository.save(domainModel));
    }

    @Transactional
    public DomainModel recarregar(DomainModel domainModel) {
        repository.flush();
        return repository.refresh(domainModel);
    }

}