package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.api.model.RestauranteDto;
import com.algaworks.cadufood.api.model.mapper.RestauranteMapper;
import com.algaworks.cadufood.domain.model.Restaurante;
import com.algaworks.cadufood.domain.service.RestauranteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/restaurantes")
@AllArgsConstructor
public class RestauranteController {

	private RestauranteService restauranteService;

	private RestauranteMapper mapper;


	@GetMapping
	public List<RestauranteDto> listar() {
		return mapper.toDtoCollection(restauranteService.listar());
	}

	@GetMapping("/{idRestaurante}")
	public ResponseEntity<RestauranteDto> buscar(@PathVariable Long idRestaurante) {
		Restaurante restaurante = restauranteService.buscar(idRestaurante);
		return ResponseEntity.ok(mapper.toDto(restaurante));
	}

	@GetMapping("/buscar-por")
	public ResponseEntity<List<RestauranteDto>> buscarPersonalizado(@RequestParam(required = false) String nome,
																 @RequestParam(value = "taxa-frete-inicial", required = false) BigDecimal taxaFreteInicial,
																 @RequestParam(value = "taxa-frete-final", required = false) BigDecimal taxaFreteFinal,
																 @RequestParam(value = "data-cadastro-inicial", required = false) LocalDateTime dataCadastroInicial,
																 @RequestParam(value = "data-cadastro-final", required = false) LocalDateTime dataCadastroFinal,
																 @RequestParam(value = "data-atualizacao-inicial", required = false) LocalDateTime dataAtualizacaoInicial,
																 @RequestParam(value = "taxa-atualizacao-final", required = false) LocalDateTime dataAtualizacaoFinal,
																 @RequestParam(value = "endereco-cep", required = false) String enderecoCep,
																 @RequestParam(value = "endereco-logradouro", required = false) String enderecoLogradouro,
																 @RequestParam(value = "endereco-numero", required = false) String enderecoNumero,
																 @RequestParam(value = "endereco-bairro", required = false) String enderecoBairro,
																 @RequestParam(value = "endereco-id-cidade", required = false) Long idEnderecoCidade,
																 @RequestParam(value = "id-cozinha", required = false) Long idCozinha) {
		List<Restaurante> restaurante = restauranteService.buscarPersonalizado(nome, taxaFreteInicial, taxaFreteFinal, dataCadastroInicial, dataCadastroFinal,
				dataAtualizacaoInicial, dataAtualizacaoFinal, enderecoCep, enderecoLogradouro, enderecoNumero,
				enderecoBairro, idEnderecoCidade, idCozinha);
		return ResponseEntity.ok(mapper.toDtoCollection(restaurante));
	}

	@GetMapping("/buscar-primeiro")
	public ResponseEntity<RestauranteDto> buscarPrimeiro() {
		Restaurante restaurante = restauranteService.buscarPrimeiro();
		return ResponseEntity.ok(mapper.toDto(restaurante));
	}

	@PostMapping
	public ResponseEntity<RestauranteDto> salvar(@RequestBody Restaurante restaurante) {
		restaurante = restauranteService.salvar(restaurante);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(mapper.toDto(restaurante));
	}

	@PutMapping("/{idRestaurante}")
	public ResponseEntity<RestauranteDto> atualizar(@PathVariable Long idRestaurante,
									   @RequestBody Restaurante restaurante) {
		restaurante = restauranteService.atualizar(idRestaurante, restaurante);
		return ResponseEntity.ok(mapper.toDto(restaurante));
	}

	@DeleteMapping("/{idRestaurante}")
	public ResponseEntity<RestauranteDto> excluir(@PathVariable Long idRestaurante) {
			restauranteService.excluir(idRestaurante);
			return ResponseEntity.noContent().build();
	}

//	@GetMapping("/buscar-por-frete")
//	public ResponseEntity<List<Restaurante>> buscarPorFrete(@RequestParam("taxa-frete-inicial") BigDecimal taxaFreteInicial,
//													   @RequestParam("taxa-frete-final") BigDecimal taxaFreteFinal) {
//		List<Restaurante> restaurante = restauranteService.buscarPorFrete(taxaFreteInicial, taxaFreteFinal);
//		return ResponseEntity.ok(restaurante);
//	}
//
//	@GetMapping("/buscar-por-nome")
//	public ResponseEntity<List<Restaurante>> buscarPorNome(@RequestParam String nome,
//														   @RequestParam(defaultValue = "-1") int quantidade) {
//		List<Restaurante> restaurante = restauranteService.buscarPorNome(nome, quantidade);
//		return ResponseEntity.ok(restaurante);
//	}

}
