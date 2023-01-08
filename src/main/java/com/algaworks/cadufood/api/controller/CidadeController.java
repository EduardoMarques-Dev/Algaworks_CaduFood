package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.domain.model.Cidade;
import com.algaworks.cadufood.domain.service.CidadeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cidades")
@AllArgsConstructor
public class CidadeController {

	private CidadeService cidadeService;

	@GetMapping
	public List<Cidade> listar() {
		return cidadeService.listar();
	}

	@GetMapping("/{cidadeId}")
	public ResponseEntity<Cidade> buscar(@PathVariable Long cidadeId) {
		Cidade cidade = cidadeService.buscar(cidadeId);
		return ResponseEntity.ok(cidade);
	}

	@PostMapping
	public ResponseEntity<Cidade> salvar(@RequestBody Cidade cidade) {
		cidade = cidadeService.salvar(cidade);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(cidade);
	}

	@PutMapping("/{cidadeId}")
	public ResponseEntity<?> atualizar(@PathVariable Long cidadeId,
									   @RequestBody Cidade cidade) {
		cidade = cidadeService.atualizar(cidadeId, cidade);
		return ResponseEntity.ok(cidade);
	}

	@DeleteMapping("/{cidadeId}")
	public ResponseEntity<Cidade> excluir(@PathVariable Long cidadeId) {
			cidadeService.excluir(cidadeId);
			return ResponseEntity.noContent().build();
	}

}
