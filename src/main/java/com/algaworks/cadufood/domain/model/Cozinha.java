package com.algaworks.cadufood.domain.model;

import com.algaworks.cadufood.core.generic.model.GenericEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Cozinha implements GenericEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String codigo;
	
	@Column(nullable = false)
	private String nome;

	@OneToMany(mappedBy = "cozinha")
	private List<Restaurante> restaurantes = new ArrayList<>();

	@Override
	@PrePersist
	public void gerarCodigo() {
		GenericEntity.super.gerarCodigo();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Cozinha cozinha)) return false;
		return Objects.equals(getId(), cozinha.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
}
