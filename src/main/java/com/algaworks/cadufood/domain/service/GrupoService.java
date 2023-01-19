package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.core.generic.crud.service.GenericService;
import com.algaworks.cadufood.domain.model.Grupo;
import com.algaworks.cadufood.domain.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupoService extends GenericService<Grupo> {

    @Autowired
    private GrupoRepository grupoRepository;

    public GrupoService(GrupoRepository repository) {
        super(repository);
    }


}
