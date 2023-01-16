package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.core.generic.crud.CustomJpaRepository;
import com.algaworks.cadufood.core.generic.crud.GenericService;
import com.algaworks.cadufood.domain.model.Usuario;
import com.algaworks.cadufood.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends GenericService<Usuario> {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioService(CustomJpaRepository<Usuario, Long> repository) {
        super(repository);
    }
}