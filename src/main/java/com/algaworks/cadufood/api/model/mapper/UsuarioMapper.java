package com.algaworks.cadufood.api.model.mapper;

import com.algaworks.cadufood.api.model.input.UsuarioInput;
import com.algaworks.cadufood.api.model.output.UsuarioOutput;
import com.algaworks.cadufood.core.generic.mapper.GenericMapper;
import com.algaworks.cadufood.domain.model.Usuario;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UsuarioMapper implements GenericMapper<Usuario, UsuarioInput, UsuarioOutput> {

    private ModelMapper modelMapper;

    @Override
    public Usuario toDomain(UsuarioInput usuarioInput) {
        return modelMapper.map(usuarioInput, Usuario.class);
    }

    @Override
    public UsuarioOutput toOutput(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioOutput.class);
    }

    @Override
    public List<Usuario> toDomainCollection(List<UsuarioInput> usuarioInputs) {
        return usuarioInputs.stream()
                .map(dto -> toDomain(dto))
                .collect(Collectors.toList());
    }

    @Override
    public List<UsuarioOutput> toOutputCollection(List<Usuario> usuarios) {
        return usuarios.stream()
                .map(entity -> toOutput(entity))
                .collect(Collectors.toList());
    }

    @Override
    public Page<UsuarioOutput> toOutputCollection(Page<Usuario> usuarios) {
        return new PageImpl<>(toOutputCollection(usuarios.toList()));
    }

    @Override
    public void updateEntity(UsuarioInput newEntity, Usuario currentEntity) {
        modelMapper.map(newEntity, currentEntity);
    }

    @Override
    public void patchEntity(HashMap<String, Object> fields, Usuario currentEntity) {
        modelMapper.map(fields, currentEntity);
    }

}
