package com.algaworks.cadufood.domain.model;

import com.algaworks.cadufood.domain.model.util.GenericEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Cidade implements GenericEntity<Cidade> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Estado estado;

}