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

	@GetMapping("/buscar-por")
	public ResponseEntity<List<Restaurante>> buscarPor(@RequestParam("taxa-frete-inicial") BigDecimal taxaFreteInicial,
													   @RequestParam("taxa-frete-final") BigDecimal taxaFreteFinal) {
		List<Restaurante> restaurante = restauranteService.buscarPor(taxaFreteInicial, taxaFreteFinal);
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
