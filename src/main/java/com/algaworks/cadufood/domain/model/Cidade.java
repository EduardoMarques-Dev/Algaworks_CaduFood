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
public class Cidade implements GenericEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String codigo;
	
	@Column(nullable = false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Estado estado;

	@Override
	@PrePersist
	public void gerarCodigo() {
		GenericEntity.super.gerarCodigo();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Cidade cidade)) return false;
		return Objects.equals(getId(), cidade.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
}