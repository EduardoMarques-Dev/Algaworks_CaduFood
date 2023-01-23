//package com.algaworks.cadufood.core.generic.crud.service;
//
//import com.algaworks.cadufood.core.generic.crud.repository.GenericRepository;
//import com.algaworks.cadufood.core.generic.filter.GenericFilter;
//import com.algaworks.cadufood.core.generic.filter.GenericSpec;
//import com.algaworks.cadufood.core.generic.model.GenericEntity;
//
//import java.util.List;
//
//public abstract class FindService<DomainModel extends GenericEntity,
//        Filter extends GenericFilter<DomainModel>> extends GenericService<DomainModel> {
//
//    GenericSpec<DomainModel> genericSpec;
//
//    public FindService(GenericRepository<DomainModel, Long> repository) {
//        super(repository);
//    }
//
//    @Override
//    public List<DomainModel> buscarPersonalizado(GenericFilter<DomainModel> genericFilter) {
//        return repository.findAll(genericSpec.usandoFiltro(genericFilter));
//    }
//}
