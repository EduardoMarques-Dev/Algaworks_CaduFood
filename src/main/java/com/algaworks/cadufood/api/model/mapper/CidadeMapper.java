package com.algaworks.cadufood.api.model.mapper;


import com.algaworks.cadufood.api.model.input.CidadeInput;
import com.algaworks.cadufood.api.model.output.CidadeOutput;
import com.algaworks.cadufood.core.generic.mapper.MapeadorGenerico;
import com.algaworks.cadufood.domain.model.Cidade;
import org.springframework.stereotype.Component;

@Component
public class CidadeMapper extends MapeadorGenerico<Cidade, CidadeInput, CidadeOutput> {

    public CidadeMapper() {
        super(Cidade.class, CidadeInput.class, CidadeOutput.class);
    }

}