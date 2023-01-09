package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.domain.exception.EntidadeEmUsoException;
import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.model.Cozinha;
import com.algaworks.cadufood.domain.model.Restaurante;
import com.algaworks.cadufood.domain.repository.RestauranteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class RestauranteService {

	private RestauranteRepository restauranteRepository;
	
	private CozinhaService cozinhaService;

	public List<Restaurante> listar() {
		List<Restaurante> restaurantes = restauranteRepository.findAll();
		return restaurantes;
	}

	public Restaurante buscar(Long idRestaurante) {
		Restaurante restaurante = buscarRestauranteOuFalhar(idRestaurante);
		return restaurante;
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

	public Restaurante buscarPrimeiro() {
		Restaurante restaurante = restauranteRepository.
				buscarPrimeiro().orElseThrow(
						() -> new EntidadeNaoEncontradaException(
								String.format("Não existe nenhum restaurante cadastrado"))
				);
		return restaurante;
	}

	@Transactional
	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaService.buscarCozinhaOuFalhar(cozinhaId);
		
		restaurante.setCozinha(cozinha);
		
		return restauranteRepository.save(restaurante);
	}

	@Transactional
	public Restaurante atualizar(Long idRestaurante, Restaurante restaurante) {
		Restaurante restauranteAtual = buscar(idRestaurante);

		BeanUtils.copyProperties(restaurante, restauranteAtual,
				"id", "formasPagamento","endereco","dataCadastro");

		return restauranteRepository.save(restauranteAtual);
	}

	@Transactional
	public void excluir(Long idRestaurante) {
		try {
			restauranteRepository.deleteById(idRestaurante);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de cozinha com código %d", idRestaurante));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Cozinha de código %d não pode ser removida, pois está em uso", idRestaurante));
		}
	}

	private Restaurante buscarRestauranteOuFalhar(Long idRestaurante) {
		return restauranteRepository.findById(idRestaurante).orElseThrow(
				() -> new EntidadeNaoEncontradaException(
						String.format("Não existe cadastro de cozinha com código %d", idRestaurante))
		);
	}

//	public List<Restaurante> buscarPorFrete(BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
//		List<Restaurante> restaurantes = restauranteRepository
//				.findByTaxaFreteBetween(taxaFreteInicial,taxaFreteFinal);
//		return restaurantes;
//	}
//
//	public List<Restaurante> buscarPorNome(String nome, int quantidade) {
//		List<Restaurante> restaurantes = new ArrayList<>();
//
//		switch (quantidade){
//			case 1:
//				restaurantes = restauranteRepository.findFirstByNomeContaining(nome);
//				break;
//			case 2:
//				restaurantes = restauranteRepository.findTop2ByNomeContaining(nome);
//				break;
//			default:
//				restaurantes = restauranteRepository.buscarPorNome(nome);
//		}
//		return restaurantes;
//	}

}
