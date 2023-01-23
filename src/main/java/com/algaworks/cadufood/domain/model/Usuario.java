package com.algaworks.cadufood.domain.model;

import com.algaworks.cadufood.core.generic.model.GenericEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Usuario implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String codigo;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(columnDefinition = "timestamp(0)",
            nullable = false)
    @CreationTimestamp()
    private LocalDateTime dataCadastro;

    @Column(columnDefinition = "timestamp(0)",
            nullable = false)
    @UpdateTimestamp()
    private LocalDateTime dataAtualizacao;

    @ManyToMany
    @JoinTable(name = "usuario_grupo",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "grupo_id"))
    private List<Grupo> grupos;

    @Override
    @PrePersist
    public void gerarCodigo() {
        GenericEntity.super.gerarCodigo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return Objects.equals(getId(), usuario.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
