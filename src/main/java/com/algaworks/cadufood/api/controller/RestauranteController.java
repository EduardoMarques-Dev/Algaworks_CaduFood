package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.api.controller.util.GenericController;
import com.algaworks.cadufood.api.mapper.RestauranteMapper;
import com.algaworks.cadufood.api.model.input.RestauranteInput;
import com.algaworks.cadufood.api.model.output.RestauranteOutput;
import com.algaworks.cadufood.domain.model.Restaurante;
import com.algaworks.cadufood.domain.service.RestauranteService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/restaurantes")
public class RestauranteController extends GenericController<Restaurante,RestauranteInput,RestauranteOutput> {

	@Autowired
	private RestauranteService restauranteService;

	@Getter
	@Autowired
	private RestauranteMapper mapper;

	public RestauranteController(RestauranteService service, RestauranteMapper mapper) {
		super(service, mapper);
	}

	@GetMapping("/buscar-por")
	public List<RestauranteOutput> buscarPersonalizado(@RequestParam(required = false) String nome,
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
													   @RequestParam(value = "endereco-cidade-id", required = false) Long enderecoCidadeId,
													   @RequestParam(value = "cozinha-id", required = false) Long cozinhaId) {
		List<Restaurante> restaurante = restauranteService.buscarPersonalizado(nome, taxaFreteInicial, taxaFreteFinal, dataCadastroInicial, dataCadastroFinal,
				dataAtualizacaoInicial, dataAtualizacaoFinal, enderecoCep, enderecoLogradouro, enderecoNumero,
				enderecoBairro, enderecoCidadeId, cozinhaId);
		return mapper.toOutputCollection(restaurante);
	}

	@PutMapping("/{idRestaurante}")
	public RestauranteOutput atualizar(@PathVariable Long idRestaurante,
									   @RequestBody RestauranteInput restauranteInput) {
		Restaurante	restauranteAtual = restauranteService.atualizar(idRestaurante, restauranteInput);
		return mapper.toOutput(restauranteAtual);
	}

}





























//	@GetMapping
//	public List<RestauranteOutput> listar() {
//		return mapper.toOutputCollection(restauranteService.listar());
//	}
//
//	@GetMapping("/{idRestaurante}")
//	public RestauranteOutput buscar(@PathVariable Long idRestaurante) {
//		Restaurante restaurante = restauranteService.buscar(idRestaurante);
//		return mapper.toOutput(restaurante);
//	}
//	@GetMapping("/buscar-primeiro")
//	public RestauranteOutput buscarPrimeiro() {
//		Restaurante restaurante = restauranteService.buscarPrimeiro();
//		return mapper.toOutput(restaurante);
//	}
//
//	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
//	public RestauranteOutput salvar(@RequestBody RestauranteInput restauranteInput) {
//		Restaurante restaurante = mapper.toDomain(restauranteInput);
//		restaurante = restauranteService.salvar(restaurante);
//		return mapper.toOutput(restaurante);
//	}
//
//
//	@DeleteMapping("/{idRestaurante}")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public void excluir(@PathVariable Long idRestaurante) {
//		restauranteService.excluir(idRestaurante);
//	}

