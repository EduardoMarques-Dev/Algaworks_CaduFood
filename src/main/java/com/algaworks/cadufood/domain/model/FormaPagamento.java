package com.algaworks.cadufood.domain.model;

import com.algaworks.cadufood.core.generic.model.EntidadeDescritiva;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class FormaPagamento implements EntidadeDescritiva {

	@Id
	@EqualsAndHashCode.Include
	private Long id;

	@Column(unique = true, nullable = false)
	private String codigo;

	@Column(nullable = false)
	private String descricao;

	@PrePersist
	public void gerarCodigo() {
		setCodigo(UUID.randomUUID().toString());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof FormaPagamento that)) return false;
		return Objects.equals(getId(), that.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
}