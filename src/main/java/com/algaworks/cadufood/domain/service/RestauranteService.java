package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.api.controller.RestauranteController;
import com.algaworks.cadufood.api.model.input.RestauranteInput;
import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.exception.NegocioException;
import com.algaworks.cadufood.domain.exception.RestauranteNaoEncontradoException;
import com.algaworks.cadufood.domain.model.Restaurante;
import com.algaworks.cadufood.domain.repository.RestauranteRepository;
import com.algaworks.cadufood.domain.service.util.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RestauranteService extends GenericService<Restaurante> {

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired @Lazy
	private RestauranteController restauranteController;

	public RestauranteService(RestauranteRepository repository) {
		super(repository);
	}

	@Override
	public Restaurante buscar(Long idDomainModel) {
		try{
			return super.buscar(idDomainModel);
		}catch (EntidadeNaoEncontradaException ex){
			throw new RestauranteNaoEncontradoException(Restaurante.class,idDomainModel);
		}
	}

	public List<Restaurante> buscarPersonalizado(String nome,
												 BigDecimal taxaFreteInicial,
												 BigDecimal taxaFreteFinal,
												 LocalDateTime dataCadastroInicial,
												 LocalDateTime dataCadastroFinal,
												 LocalDateTime dataAtualizacaoInicial,
												 LocalDateTime dataAtualizacaoFinal,
												 String enderecoCep,
												 String enderecoLogradouro,
												 String enderecoNumero,
												 String enderecoBairro,
												 Long enderecoCidadeId,
												 Long cozinhaId) {
		List<Restaurante> restaurantes = restauranteRepository.
				buscarPersonalizado(nome, taxaFreteInicial, taxaFreteFinal, dataCadastroInicial, dataCadastroFinal,
						dataAtualizacaoInicial, dataAtualizacaoFinal, enderecoCep, enderecoLogradouro, enderecoNumero,
						enderecoBairro, enderecoCidadeId, cozinhaId);
		return restaurantes;
	}

	@Transactional
	public Restaurante atualizar(Long idRestaurante, RestauranteInput restauranteInput) {
		Restaurante restauranteAtual = buscarDomainModelOuFalhar(idRestaurante);

		restauranteController.getMapper().updateEntity(restauranteInput,restauranteAtual);

		try{
			return salvarERecarregar(restauranteAtual);
		}catch (DataIntegrityViolationException ex){
			throw new NegocioException(ex.getMessage());
		}
	}

}