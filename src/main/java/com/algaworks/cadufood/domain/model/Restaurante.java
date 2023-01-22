package com.algaworks.cadufood.domain.model;

import com.algaworks.cadufood.core.generic.model.FatherEntity;
import com.algaworks.cadufood.core.generic.model.GenericEntity;
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
import java.util.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Restaurante implements FatherEntity<Restaurante> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String codigo;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private boolean ativo = Boolean.TRUE;

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
	private Set<FormaPagamento> formasPagamento = new HashSet<>();

	public void ativar(){
		setAtivo(true);
	}

	public void inativar(){
		setAtivo(false);
	}

	public boolean associarFormaPagamento(FormaPagamento formaPagamento){
		return getFormasPagamento().add(formaPagamento);
	}

	public boolean desassociarFormaPagamento(FormaPagamento formaPagamento){
		return getFormasPagamento().remove(formaPagamento);
	}

	public List<FormaPagamento> getFormaPagamento(FormaPagamento formaPagamento){
		return getFormasPagamento().stream().filter(
				itemFormaPagamento -> itemFormaPagamento.equals(formaPagamento)
		).toList();
	}

	@Override
	@PrePersist
	public void gerarCodigo() {
		FatherEntity.super.gerarCodigo();
	}

	@Override
	public Collection<?> listarSubRecurso(Object subRecurso) {
		if (((Class) subRecurso).getSimpleName().equals("FormaPagamento")){
			return getFormasPagamento();
		}
		return new ArrayList<>();
	}

	@Override
	public Collection<?> buscarSubRecurso(Object subRecurso) {
		if (subRecurso instanceof FormaPagamento formaPagamento){
			return getFormasPagamento().stream().filter(
					itemFormaPagamento -> itemFormaPagamento.equals(formaPagamento)
			).toList();
		}
		return null;
	}

	@Override
	public boolean associarSubRecurso(Object subRecurso) {
		if (subRecurso instanceof FormaPagamento formaPagamento){
			return getFormasPagamento().add(formaPagamento);
		}
		return false;
	}

	@Override
	public boolean desassociarSubRecurso(Object subRecurso) {
		if (subRecurso instanceof FormaPagamento formaPagamento){
			return getFormasPagamento().remove(formaPagamento);
		}
		return false;
	}
}
