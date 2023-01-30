package com.algaworks.cadufood.domain.model;

import com.algaworks.cadufood.core.generic.model.EntidadeGenerica;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Estado implements EntidadeGenerica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String codigo;

	@Column(nullable = false)
	private String nome;

	@PrePersist
	public void gerarCodigo() {
		setCodigo(UUID.randomUUID().toString());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Estado estado)) return false;
		return Objects.equals(getId(), estado.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
}