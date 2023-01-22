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
	public Restaurante buscar(String domainModelId) {
		try{
			return super.buscar(domainModelId);
		}catch (EntidadeNaoEncontradaException ex){
			throw new RestauranteNaoEncontradoException(Restaurante.class, domainModelId);
		}
	}

	@Transactional
	public void associarFormaPagamento(String restauranteCodigo, String formaPagamentoCodigo) {
		Restaurante restaurante = buscar(restauranteCodigo);
		FormaPagamento formaPagamento = formaPagamentoService.buscar(formaPagamentoCodigo);
		restaurante.associarFormaPagamento(formaPagamento);
	}

	@Transactional
	public void desassociarFormaPagamento(String restauranteCodigo, String formaPagamentoCodigo) {
		Restaurante restaurante = buscar(restauranteCodigo);
		FormaPagamento formaPagamento = formaPagamentoService.buscar(formaPagamentoCodigo);
		restaurante.desassociarFormaPagamento(formaPagamento);
	}


	@Transactional
	public void ativar(String restauranteCodigo){
		Restaurante restauranteAtual = buscar(restauranteCodigo);
		restauranteAtual.ativar();
	}

	@Transactional
	public void inativar(String restauranteCodigo){
		Restaurante restauranteAtual = buscar(restauranteCodigo);
		restauranteAtual.inativar();
	}

}