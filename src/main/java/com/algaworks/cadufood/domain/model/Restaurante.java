package com.algaworks.cadufood.domain.model;

import com.algaworks.cadufood.core.generic.model.EntidadeAtivavel;
import com.algaworks.cadufood.core.generic.model.EntidadeGenerica;
import com.algaworks.cadufood.core.generic.model.EntidadePai;
import com.algaworks.cadufood.core.generic.model.EntidadePaiImpl;
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


@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Restaurante implements EntidadePai, EntidadeAtivavel {

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

	@Transient
	private EntidadePaiImpl entidadePai = new EntidadePaiImpl(Restaurante.this);


	@Override
	public void setSubRecursos() {
		entidadePai.adicionarSubrecurso("formasPagamento", getFormasPagamento());
		entidadePai.adicionarSubrecurso("produto", getProduto());
	}

	@Override
	public Map<String, Collection<EntidadeGenerica>> getSubRecursos() {
		return entidadePai.getSubRecursos();
	}

	@Override
	public Collection<?> listarSubRecurso(String chave) {
		return entidadePai.listarSubRecurso(chave);
	}

	@Override
	public Collection<?> buscarSubRecurso(String chave, EntidadeGenerica subRecurso) {
		return entidadePai.buscarSubRecurso(chave, subRecurso);
	}

	@Override
	public void associarSubRecurso(String chave, EntidadeGenerica subRecurso) {
		entidadePai.associarSubRecurso(chave, subRecurso);
	}

	@Override
	public void desassociarSubRecurso(String chave, EntidadeGenerica subRecurso) {
		entidadePai.desassociarSubRecurso(chave, subRecurso);
	}

	@PrePersist
	public void gerarCodigo() {
		setCodigo(UUID.randomUUID().toString());
	}

	@Override
	public void ativar() {
		setAtivo(true);
	}

	@Override
	public void inativar() {
		setAtivo(false);
	}



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Restaurante that)) return false;
		return Objects.equals(getId(), that.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
}
