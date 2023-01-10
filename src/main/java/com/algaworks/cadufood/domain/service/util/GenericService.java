package com.algaworks.cadufood.domain.service.util;

import com.algaworks.cadufood.domain.exception.RestauranteNaoEncontradoException;
import com.algaworks.cadufood.domain.model.util.GenericEntity;
import com.algaworks.cadufood.domain.model.Restaurante;
import com.algaworks.cadufood.domain.repository.util.norepositorybean.CustomJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
public abstract class GenericService<DomainModel extends GenericEntity<DomainModel>> {

    private final CustomJpaRepository<DomainModel, Long> repository;

    public List<DomainModel> listar() {
        List<DomainModel> domainModelList = repository.findAll();
        return domainModelList;
    }

    public Page<DomainModel> getPage(Pageable pageable){
        return repository.findAll(pageable);
    }

    public DomainModel buscar(Long idDomainModel) {
        DomainModel domainModel = buscarDomainModelOuFalhar(idDomainModel);
        return domainModel;
    }

    public DomainModel buscarPrimeiro() {
        DomainModel domainModel = repository.
                buscarPrimeiro().orElseThrow(() -> new RestauranteNaoEncontradoException(Restaurante.class));
        return domainModel;
    }

    @Transactional
    public DomainModel salvar(DomainModel domainModel) {
        return salvarERecarregar(domainModel);
    }

    @Transactional
    public void excluir(Long idDomainModel) {
        repository.deleteById(idDomainModel);
    }

    public DomainModel buscarDomainModelOuFalhar(Long idDomainModel) {
        return repository.findById(idDomainModel).orElseThrow(null);
    }

    @Transactional
    public DomainModel salvarERecarregar(DomainModel domainModel) {
        return repository.refresh(repository.saveAndFlush(domainModel));
    }


//    
//    
//    @Transactional
//    public DomainModel update(DomainModel updated){
//        DomainModel dbDomain = get(updated.getId());
//        dbDomain.update(updated);
//
//        return repository.save(dbDomain);
//    }
//
//    @Transactional
//    public DomainModel create(DomainModel newDomain){
//        DomainModel dbDomain = newDomain.createNewInstance();
//        return repository.save(dbDomain);
//    }
//
//    @Transactional
//    public void delete(Long id){
//        //check if object with this id exists
//        get(id);
//        repository.deleteById(id);
//    }
}