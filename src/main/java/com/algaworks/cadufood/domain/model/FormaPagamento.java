package com.algaworks.cadufood.domain.model;

import com.algaworks.cadufood.core.generic.model.DescriptiveEntity;
import com.algaworks.cadufood.core.generic.model.GenericEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
@Entity
public class FormaPagamento implements DescriptiveEntity<FormaPagamento> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
}