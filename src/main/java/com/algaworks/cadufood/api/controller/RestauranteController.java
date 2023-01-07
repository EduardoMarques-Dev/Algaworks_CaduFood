package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.domain.model.Restaurante;
import com.algaworks.cadufood.domain.service.RestauranteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "/restaurantes")
@AllArgsConstructor
public class RestauranteController {

	private RestauranteService restauranteService;


	@GetMapping
	public List<Restaurante> listar() {
		return restauranteService.listar();
	}

	@GetMapping("/{restauranteId}")
	public ResponseEntity<Restaurante> buscar(@PathVariable Long restauranteId) {
		Restaurante restaurante = restauranteService.buscar(restauranteId);
		return ResponseEntity.ok(restaurante);
	}

	@GetMapping("/buscar-por-frete")
	public ResponseEntity<List<Restaurante>> buscarPorFrete(@RequestParam("taxa-frete-inicial") BigDecimal taxaFreteInicial,
													   @RequestParam("taxa-frete-final") BigDecimal taxaFreteFinal) {
		List<Restaurante> restaurante = restauranteService.buscarPorFrete(taxaFreteInicial, taxaFreteFinal);
		return ResponseEntity.ok(restaurante);
	}

	@GetMapping("/buscar-por-nome")
	public ResponseEntity<List<Restaurante>> buscarPorNome(@RequestParam String nome,
														   @RequestParam(defaultValue = "-1") int quantidade) {
		List<Restaurante> restaurante = restauranteService.buscarPorNome(nome, quantidade);
		return ResponseEntity.ok(restaurante);
	}

	@GetMapping("/buscar-por-nome-e-frete")
	public ResponseEntity<List<Restaurante>> buscarPorNomeEFrete(@RequestParam(required = false) String nome,
														   @RequestParam(value = "taxa-frete-inicial", required = false) BigDecimal taxaFreteInicial,
														   @RequestParam(value = "taxa-frete-final", required = false) BigDecimal taxaFreteFinal) {
		List<Restaurante> restaurante = restauranteService.buscarPorNomeEFrete(nome, taxaFreteInicial,taxaFreteFinal);
		return ResponseEntity.ok(restaurante);
	}

	@GetMapping("/buscar-primeiro")
	public ResponseEntity<Restaurante> buscarPrimeiro() {
		Restaurante restaurante = restauranteService.buscarPrimeiro();
		return ResponseEntity.ok(restaurante);
	}

	@PostMapping
	public ResponseEntity<Restaurante> salvar(@RequestBody Restaurante restaurante) {
		restaurante = restauranteService.salvar(restaurante);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(restaurante);
	}

	@PutMapping("/{restauranteId}")
	public ResponseEntity<?> atualizar(@PathVariable Long restauranteId,
									   @RequestBody Restaurante restaurante) {
		restaurante = restauranteService.atualizar(restauranteId, restaurante);
		return ResponseEntity.ok(restaurante);
	}

	@DeleteMapping("/{restauranteId}")
	public ResponseEntity<?> excluir(@PathVariable Long restauranteId) {
			restauranteService.excluir(restauranteId);
			return ResponseEntity.noContent().build();
	}

}
