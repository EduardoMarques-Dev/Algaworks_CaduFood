package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.core.generic.crud.service.GenericService;
import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.exception.negocio.RestauranteNaoEncontradoException;
import com.algaworks.cadufood.domain.model.FormaPagamento;
import com.algaworks.cadufood.domain.model.Restaurante;
import com.algaworks.cadufood.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class RestauranteService extends GenericService<Restaurante> {

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private FormaPagamentoService formaPagamentoService;

	public RestauranteService(RestauranteRepository repository) {
		super(repository);
	}

	@Override
	public Restaurante buscar(Long domainModelId) {
		try{
			return super.buscar(domainModelId);
		}catch (EntidadeNaoEncontradaException ex){
			throw new RestauranteNaoEncontradoException(Restaurante.class, domainModelId);
		}
	}

	@Transactional
	public void associarFormaPagamento(Long restauranteId, Long formaPagamentoId) {
		Restaurante restaurante = buscar(restauranteId);
		FormaPagamento formaPagamento = formaPagamentoService.buscar(formaPagamentoId);
		restaurante.associarFormaPagamento(formaPagamento);
	}

	@Transactional
	public void desassociarFormaPagamento(Long restauranteId, Long formaPagamentoId) {
		Restaurante restaurante = buscar(restauranteId);
		FormaPagamento formaPagamento = formaPagamentoService.buscar(formaPagamentoId);
		restaurante.desassociarFormaPagamento(formaPagamento);
	}


	@Transactional
	public void ativar(Long idRestaurante){
		Restaurante restauranteAtual = buscar(idRestaurante);
		restauranteAtual.ativar();
	}

	@Transactional
	public void inativar(Long idRestaurante){
		Restaurante restauranteAtual = buscar(idRestaurante);
		restauranteAtual.inativar();
	}

}