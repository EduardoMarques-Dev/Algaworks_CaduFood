package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.domain.exception.EntidadeEmUsoException;
import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.model.Estado;
import com.algaworks.cadufood.domain.service.EstadoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados")
@AllArgsConstructor
public class EstadoController {

	private EstadoService estadoService;


	@GetMapping
	public List<Estado> listar() {
		return estadoService.listar();
	}

	@GetMapping("/{estadoId}")
	public ResponseEntity<Estado> buscar(@PathVariable Long estadoId) {
		Estado estado = estadoService.buscar(estadoId);

		if (estado != null) {
			return ResponseEntity.ok(estado);
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Estado adicionar(@RequestBody Estado estado) {
		return estadoService.salvar(estado);
	}

	@PutMapping("/{estadoId}")
	public ResponseEntity<Estado> atualizar(@PathVariable Long estadoId,
											@RequestBody Estado estado) {
		Estado estadoAtual = estadoService.buscar(estadoId);

		if (estadoAtual != null) {
			BeanUtils.copyProperties(estado, estadoAtual, "id");

			estadoAtual = estadoService.salvar(estadoAtual);
			return ResponseEntity.ok(estadoAtual);
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{estadoId}")
	public ResponseEntity<?> excluir(@PathVariable Long estadoId) {
		try {
			estadoService.excluir(estadoId);
			return ResponseEntity.noContent().build();

		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();

		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body(e.getMessage());
		}
	}

}
