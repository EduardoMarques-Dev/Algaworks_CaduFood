package com.algaworks.cadufood.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Embeddable
@Getter
@Setter
@RequiredArgsConstructor
public class Endereco {

    @Column(name = "endereco_cep",
    nullable = false)
    private String cep;

    @Column(name = "endereco_logradouro",
    nullable = false)
    private String logradouro;

    @Column(name = "endereco_numero",
    nullable = false)
    private String numero;

    @Column(name = "endereco_bairro",
    nullable = false)
    private String bairro;

    @ManyToOne
    @JoinColumn(name = "endereco_cidade_id",
    nullable = false)
    private Cidade cidade;

}
