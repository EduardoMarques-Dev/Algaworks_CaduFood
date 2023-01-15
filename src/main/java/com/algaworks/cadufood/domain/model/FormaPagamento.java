package com.algaworks.cadufood.domain.model;

import com.algaworks.cadufood.core.generic.model.DescriptiveEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class FormaPagamento implements DescriptiveEntity<FormaPagamento> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String descricao;

}