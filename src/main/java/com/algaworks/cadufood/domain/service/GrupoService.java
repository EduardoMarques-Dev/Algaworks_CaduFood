package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.core.generic.crud.service.ServicoGenerico;
import com.algaworks.cadufood.domain.model.Grupo;
import com.algaworks.cadufood.domain.repository.GrupoRepository;
import org.springframework.stereotype.Service;

@Service
public class GrupoService extends ServicoGenerico<Grupo> {

    public GrupoService(GrupoRepository repositorio) {
        super(repositorio);
    }
}
