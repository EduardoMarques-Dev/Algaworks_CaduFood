package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.model.Restaurante;
import com.algaworks.cadufood.domain.service.RestauranteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

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

		if (restaurante != null) {
			return ResponseEntity.ok(restaurante);
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Restaurante restaurante) {
		try {
			restaurante = restauranteService.salvar(restaurante);

			return ResponseEntity.status(HttpStatus.CREATED)
					.body(restaurante);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
	}

	@PutMapping("/{restauranteId}")
	public ResponseEntity<?> atualizar(@PathVariable Long restauranteId,
									   @RequestBody Restaurante restaurante) {
		try {
			Restaurante restauranteAtual = restauranteService.buscar(restauranteId);

			if (restauranteAtual != null) {
				BeanUtils.copyProperties(restaurante, restauranteAtual, "id");

				restauranteAtual = restauranteService.salvar(restauranteAtual);
				return ResponseEntity.ok(restauranteAtual);
			}

			return ResponseEntity.notFound().build();

		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
	}

	@PatchMapping("/{restauranteId}")
	public ResponseEntity<?> atualizarParcial(@PathVariable Long restauranteId,
											  @RequestBody Map<String, Object> campos) {
		Restaurante restauranteAtual = restauranteService.buscar(restauranteId);

		if (restauranteAtual == null) {
			return ResponseEntity.notFound().build();
		}

		merge(campos, restauranteAtual);

		return atualizar(restauranteId, restauranteAtual);
	}

	private void merge(Map<String, Object> dadosOrigem, Restaurante restauranteDestino) {
		ObjectMapper objectMapper = new ObjectMapper();
		Restaurante restauranteOrigem = objectMapper.convertValue(dadosOrigem, Restaurante.class);

		dadosOrigem.forEach((nomePropriedade, valorPropriedade) -> {
			Field field = ReflectionUtils.findField(Restaurante.class, nomePropriedade);
			field.setAccessible(true);

			Object novoValor = ReflectionUtils.getField(field, restauranteOrigem);

//			System.out.println(nomePropriedade + " = " + valorPropriedade + " = " + novoValor);

			ReflectionUtils.setField(field, restauranteDestino, novoValor);
		});
	}

}
