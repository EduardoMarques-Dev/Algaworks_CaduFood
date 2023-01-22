package com.algaworks.cadufood.core.generic.crud.service;

import com.algaworks.cadufood.core.generic.ParametrosBusca;
import com.algaworks.cadufood.core.generic.crud.repository.GenericRepository;
import com.algaworks.cadufood.core.generic.model.GenericEntity;
import com.algaworks.cadufood.domain.exception.EntidadeEmUsoException;
import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.exception.NegocioException;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
public abstract class GenericService<DomainModel extends GenericEntity<DomainModel>> {

    private final GenericRepository<DomainModel, Long> repository;

    public List<DomainModel> listar() {
        return repository.findAll();
    }

    public DomainModel buscar(String domainModelCodigo) {
        return buscarDomainModelOuFalhar(domainModelCodigo);
    }


    public List<DomainModel> buscarPersonalizado(ParametrosBusca<DomainModel> parametrosBusca) {
        return repository.
                buscarPersonalizado(parametrosBusca);
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