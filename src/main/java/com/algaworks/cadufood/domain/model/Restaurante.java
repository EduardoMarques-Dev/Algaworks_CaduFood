package com.algaworks.cadufood.domain.model;

import com.algaworks.cadufood.domain.model.util.GenericEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Restaurante implements GenericEntity<Restaurante> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(name = "taxa_frete",
			nullable = false)
	private BigDecimal taxaFrete;

	@Column(columnDefinition = "timestamp(0)",
			nullable = false)
	@CreationTimestamp()
	private LocalDateTime dataCadastro;

	@Column(columnDefinition = "timestamp(0)",
			nullable = false)
	@UpdateTimestamp
	private LocalDateTime dataAtualizacao;

	@Embedded
	private Endereco endereco;

	@JsonIgnoreProperties(value = "nome", allowGetters = true)
	@ManyToOne
	@JoinColumn(name = "cozinha_id",
			nullable = false)
	private Cozinha cozinha;

	@JsonIgnore
	@OneToMany(mappedBy = "restaurante")
	@ToString.Exclude
	private List<Produto> produto;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "restaurante_forma_pagamento",
			joinColumns = @JoinColumn(name = "restaurante_id"),
			inverseJoinColumns = @JoinColumn(name = "forma_pagamento_id"))
	@ToString.Exclude
	private List<FormaPagamento> formasPagamento = new ArrayList<>();

}
