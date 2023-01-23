package com.algaworks.cadufood.domain.model;

import com.algaworks.cadufood.core.generic.model.GenericEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Grupo implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String codigo;

    @ManyToMany
    @JoinTable(name = "grupo_permissao",
            joinColumns = @JoinColumn(name = "grupo_id"),
            inverseJoinColumns = @JoinColumn(name = "permissao_id"))
    private List<Permissao> permissoes;

    @Override
    @PrePersist
    public void gerarCodigo() {
        GenericEntity.super.gerarCodigo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grupo grupo)) return false;
        return Objects.equals(getId(), grupo.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}