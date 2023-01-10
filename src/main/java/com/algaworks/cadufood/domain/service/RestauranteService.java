package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.api.controller.RestauranteController;
import com.algaworks.cadufood.api.model.input.RestauranteInput;
import com.algaworks.cadufood.domain.exception.NegocioException;
import com.algaworks.cadufood.domain.model.Restaurante;
import com.algaworks.cadufood.domain.repository.RestauranteRepository;
import com.algaworks.cadufood.domain.repository.util.norepositorybean.CustomJpaRepository;
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
												 Long idEnderecoCidade,
												 Long idCozinha) {
		List<Restaurante> restaurantes = restauranteRepository.
				buscarPersonalizado(nome, taxaFreteInicial, taxaFreteFinal, dataCadastroInicial, dataCadastroFinal,
						dataAtualizacaoInicial, dataAtualizacaoFinal, enderecoCep, enderecoLogradouro, enderecoNumero,
						enderecoBairro, idEnderecoCidade, idCozinha);
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




















//	public Restaurante buscarPrimeiro() {
//		Restaurante restaurante = restauranteRepository.
//				buscarPrimeiro().orElseThrow(() -> new RestauranteNaoEncontradoException(Restaurante.class));
//		return restaurante;
//	}
//
//	public List<Restaurante> listar() {
//		List<Restaurante> restaurantes = restauranteRepository.findAll();
//		return restaurantes;
//	}
//
//	public Restaurante buscar(Long idRestaurante) {
//		Restaurante restaurante = buscarRestauranteOuFalhar(idRestaurante);
//		return restaurante;
//	}
//
//	@Transactional
//	public Restaurante salvar(Restaurante restaurante) {
//		return salvarERecarregar(restaurante);
//	}
//
//	@Transactional
//	public void excluir(Long idRestaurante) {
//		try {
//			restauranteRepository.deleteById(idRestaurante);
//		} catch (EmptyResultDataAccessException e) {
//			throw new RestauranteNaoEncontradoException(Restaurante.class, idRestaurante);
//		} catch (DataIntegrityViolationException e) {
//			throw new EntidadeEmUsoException(Restaurante.class, idRestaurante);
//		}
//	}
//	private Restaurante buscarRestauranteOuFalhar(Long idRestaurante) {
//		return restauranteRepository.findById(idRestaurante).orElseThrow(
//				() -> new RestauranteNaoEncontradoException(Restaurante.class, idRestaurante));
//	}
//
//	@Transactional
//	private Restaurante salvarERecarregar(Restaurante restaurante) {
//		return restauranteRepository.refresh(restauranteRepository.saveAndFlush(restaurante));
//	}
