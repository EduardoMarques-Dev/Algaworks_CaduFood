package com.algaworks.cadufood.api.model.mapper;

import com.algaworks.cadufood.api.model.input.UsuarioInput;
import com.algaworks.cadufood.api.model.resume.UsuarioUpdate;
import com.algaworks.cadufood.api.model.output.UsuarioOutput;
import com.algaworks.cadufood.core.generic.mapper.GenericMapper;
import com.algaworks.cadufood.domain.model.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper extends GenericMapper<Usuario, UsuarioInput, UsuarioOutput> {

    private ModelMapper modelMapper = new ModelMapper();

    public UsuarioMapper() {
        super(Usuario.class, UsuarioInput.class, UsuarioOutput.class);
    }

    public void updateEntity(UsuarioUpdate newEntity, Usuario currentEntity) {
        modelMapper.map(newEntity, currentEntity);
    }
}
