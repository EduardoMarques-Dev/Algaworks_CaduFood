package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.core.generic.crud.service.ServicoGenerico;
import com.algaworks.cadufood.domain.exception.NegocioException;
import com.algaworks.cadufood.domain.model.Usuario;
import com.algaworks.cadufood.domain.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsuarioService extends ServicoGenerico<Usuario> {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository repositorio) {
        super(repositorio);
        this.usuarioRepository = repositorio;
    }

    @Override
    @Transactional
    public Usuario salvar(Usuario usuario) {
//        usuarioRepository.detach(usuario);

        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());

        if (usuarioExistente.isPresent()
        && !usuarioExistente.get().equals(usuario)){
            throw new NegocioException(
                    String.format("Já existe um usuário cadastrado com o e-mail '%s'", usuario.getEmail())
            );
        }

        return super.salvar(usuario);
    }
}