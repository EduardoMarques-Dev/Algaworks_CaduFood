package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.domain.model.Cozinha;
import com.algaworks.cadufood.domain.service.CozinhaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cozinhas")
@AllArgsConstructor
public class CozinhaController {

	private CozinhaService cozinhaService;

	@GetMapping
	public List<Cozinha> listar() {
		return cozinhaService.listar();
	}

	@GetMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId) {
		Cozinha cozinha = cozinhaService.buscar(cozinhaId);
		return ResponseEntity.ok(cozinha);
	}

	@GetMapping("/buscar-por")
	public ResponseEntity<List<Cozinha>> buscarPor(@RequestParam String nome) {
		List<Cozinha> cozinhas = cozinhaService.buscarPorNome(nome);
		return ResponseEntity.ok(cozinhas);
	}

	@PostMapping
	public ResponseEntity<Cozinha> salvar(@RequestBody Cozinha cozinha) {
		cozinha = cozinhaService.salvar(cozinha);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(cozinha);
	}

	@PutMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId,
											 @RequestBody Cozinha cozinha) {
		cozinha = cozinhaService.atualizar(cozinhaId, cozinha);
		return ResponseEntity.ok(cozinha);
	}

	@DeleteMapping("/{cozinhaId}")
	public ResponseEntity<?> excluir(@PathVariable Long cozinhaId) {
		cozinhaService.excluir(cozinhaId);
		return ResponseEntity.noContent().build();
	}

}
