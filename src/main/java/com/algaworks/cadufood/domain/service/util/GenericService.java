package com.algaworks.cadufood.domain.service.util;

import com.algaworks.cadufood.domain.exception.EntidadeEmUsoException;
import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.model.util.GenericEntity;
import com.algaworks.cadufood.domain.repository.util.interfacequeries.ParametrosBusca;
import com.algaworks.cadufood.domain.repository.util.norepositorybean.CustomJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
public abstract class GenericService<DomainModel extends GenericEntity<DomainModel>> {

    private final CustomJpaRepository<DomainModel, Long> repository;

    public List<DomainModel> listar() {
        return repository.findAll();
    }

    public Page<DomainModel> getPage(Pageable pageable){
        return repository.findAll(pageable);
    }

    public DomainModel buscar(Long idDomainModel) {
        return buscarDomainModelOuFalhar(idDomainModel);
    }

    public List<DomainModel> buscarPersonalizado(ParametrosBusca<DomainModel> parametrosBusca) {
        return repository.
                buscarPersonalizado(parametrosBusca);
    }

    public DomainModel buscarPrimeiro() {
        return repository.
                buscarPrimeiro().orElseThrow(EntidadeNaoEncontradaException::new);
    }

    @Transactional
    public DomainModel salvar(DomainModel domainModel) {
        return salvarERecarregar(domainModel);
    }

    @Transactional
    public void excluir(Long idDomainModel) {
        try{
            repository.deleteById(idDomainModel);
            repository.flush();
        } catch (EmptyResultDataAccessException ex){
            throw new EntidadeNaoEncontradaException(idDomainModel);
        } catch (DataIntegrityViolationException ex){
            throw new EntidadeEmUsoException();
        }
    }

    private DomainModel buscarDomainModelOuFalhar(Long idDomainModel) {
        return repository.findById(idDomainModel).orElseThrow(() -> new EntidadeNaoEncontradaException(
                idDomainModel
        ));
    }

    @Transactional
    private DomainModel salvarERecarregar(DomainModel domainModel) {
        return repository.refresh(repository.saveAndFlush(domainModel));
    }

}