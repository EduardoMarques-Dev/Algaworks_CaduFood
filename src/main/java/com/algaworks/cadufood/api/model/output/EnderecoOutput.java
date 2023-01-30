package com.algaworks.cadufood.api.model.output;

import com.algaworks.cadufood.api.model.resume.CidadeResume;
import com.algaworks.cadufood.core.generic.model.DTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoOutput implements DTO {

    private String cep;

    private String logradouro;

    private String numero;

    private String bairro;

    private CidadeResume cidade;

}
