package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.api.mapper.CozinhaMapper;
import com.algaworks.cadufood.api.model.input.CozinhaInput;
import com.algaworks.cadufood.api.model.output.CozinhaOutput;
import com.algaworks.cadufood.domain.model.Cozinha;
import com.algaworks.cadufood.domain.service.CozinhaService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cozinhas")
@AllArgsConstructor
public class CozinhaController {

	private CozinhaService cozinhaService;

	@Getter
	private CozinhaMapper mapper;

	@GetMapping
	public List<CozinhaOutput> listar() {
		return mapper.toOutputCollection(cozinhaService.listar());
	}

	@GetMapping("/{cozinhaId}")
	public ResponseEntity<CozinhaOutput> buscar(@PathVariable Long cozinhaId) {
		Cozinha cozinha = cozinhaService.buscar(cozinhaId);
		return ResponseEntity.ok(mapper.toOutput(cozinha));
	}

	@PostMapping
	public ResponseEntity<CozinhaOutput> salvar(@RequestBody CozinhaInput cozinhaInput) {
		Cozinha cozinha = mapper.toDomain(cozinhaInput);
		cozinha = cozinhaService.salvar(cozinha);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(mapper.toOutput(cozinha));
	}

	@PutMapping("/{cozinhaId}")
	public ResponseEntity<CozinhaOutput> atualizar(@PathVariable Long cozinhaId,
												   @RequestBody CozinhaInput cozinhaInput) {
		Cozinha cozinhaAtual = cozinhaService.atualizar(cozinhaId, cozinhaInput);
		return ResponseEntity.ok(mapper.toOutput(cozinhaAtual));
	}

	@DeleteMapping("/{cozinhaId}")
	public ResponseEntity<?> excluir(@PathVariable Long cozinhaId) {
		cozinhaService.excluir(cozinhaId);
		return ResponseEntity.noContent().build();
	}

}
