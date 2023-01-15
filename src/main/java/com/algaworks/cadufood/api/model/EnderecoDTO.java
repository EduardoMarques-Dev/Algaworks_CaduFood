package com.algaworks.cadufood.api.model;

import com.algaworks.cadufood.api.model.output.CidadeOutput;
import com.algaworks.cadufood.api.model.resume.CidadeResume;
import com.algaworks.cadufood.core.generic.model.DataTransferObject;
import com.algaworks.cadufood.domain.model.Cidade;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO implements DataTransferObject<EnderecoDTO> {

    private String cep;

    private String logradouro;

    private String numero;

    private String bairro;

    private CidadeResume cidade;

}
