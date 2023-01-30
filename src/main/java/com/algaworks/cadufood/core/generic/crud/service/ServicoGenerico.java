package com.algaworks.cadufood.core.generic.crud.service;

import com.algaworks.cadufood.core.generic.crud.repository.RepositorioGenerico;
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
 * Classe que representa um serviço REST genérico.
 *
 * @author Carlos Eduardo Marques Pereira
 */
public abstract class ServicoGenerico<DomainModel extends EntidadeGenerica> {

    @Autowired
    protected RepositorioGenerico<DomainModel, Long> repositorio;

//    @Autowired
//    protected GenericSpecification<DomainModel> genericSpecification;

    public List<DomainModel> listar() {
        return repositorio.findAll();
    }

    public DomainModel buscar(String domainModelCodigo) {
        return buscarOuFalhar(domainModelCodigo);
    }

//    public Page<DomainModel> buscarPersonalizado(GenericFilter<DomainModel> genericFilter, Pageable pageable) {
//        return repository.findAll(genericSpecification.usandoFiltro(genericFilter), pageable);
//    }

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
            repositorio.deleteByCodigo(domainModelCodigo);
            repositorio.flush();
        } catch (EmptyResultDataAccessException ex){
            throw new EntidadeNaoEncontradaException(domainModelCodigo);
        } catch (DataIntegrityViolationException ex){
            throw new EntidadeEmUsoException();
        }
    }

    private DomainModel buscarOuFalhar(String domainModelCodigo) {
        return repositorio.findByCodigo(domainModelCodigo).orElseThrow(() -> new EntidadeNaoEncontradaException(
                domainModelCodigo
        ));
    }

    @Transactional
    private DomainModel salvarERecarregar(DomainModel domainModel) {
        return recarregar(repositorio.save(domainModel));
    }

    @Transactional
    public DomainModel recarregar(DomainModel domainModel) {
        repositorio.flush();
        return repositorio.refresh(domainModel);
    }

}