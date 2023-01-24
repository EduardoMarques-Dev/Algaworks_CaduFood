package com.algaworks.cadufood.domain.model;

import com.algaworks.cadufood.core.generic.model.DescriptiveEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class FormaPagamento implements DescriptiveEntity {

	@Id
	@EqualsAndHashCode.Include
	private Long id;

	@Column(unique = true, nullable = false)
	private String codigo;

	@Column(nullable = false)
	private String descricao;

	@Override
	@PrePersist
	public void gerarCodigo() {
		DescriptiveEntity.super.gerarCodigo();
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