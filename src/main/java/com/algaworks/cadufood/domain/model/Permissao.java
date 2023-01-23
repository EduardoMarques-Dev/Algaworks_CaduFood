package com.algaworks.cadufood.domain.model;

import com.algaworks.cadufood.core.generic.model.GenericEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Permissao implements GenericEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String codigo;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String descricao;

	@Override
	@PrePersist
	public void gerarCodigo() {
		GenericEntity.super.gerarCodigo();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Permissao permissao)) return false;
		return Objects.equals(getId(), permissao.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
}