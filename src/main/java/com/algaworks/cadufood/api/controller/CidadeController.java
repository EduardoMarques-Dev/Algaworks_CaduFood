package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.domain.exception.EntidadeEmUsoException;
import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.model.Cidade;
import com.algaworks.cadufood.domain.service.CidadeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
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

		if (cidade != null) {
			return ResponseEntity.ok(cidade);
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Cidade cidade) {
		try {
			cidade = cidadeService.salvar(cidade);

			return ResponseEntity.status(HttpStatus.CREATED)
					.body(cidade);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
	}

	@PutMapping("/{cidadeId}")
	public ResponseEntity<?> atualizar(@PathVariable Long cidadeId,
									   @RequestBody Cidade cidade) {
		try {
			Cidade cidadeAtual = cidadeService.buscar(cidadeId);

			if (cidadeAtual != null) {
				BeanUtils.copyProperties(cidade, cidadeAtual, "id");

				cidadeAtual = cidadeService.salvar(cidadeAtual);
				return ResponseEntity.ok(cidadeAtual);
			}

			return ResponseEntity.notFound().build();

		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
	}

	@DeleteMapping("/{cidadeId}")
	public ResponseEntity<Cidade> excluir(@PathVariable Long cidadeId) {
		try {
			cidadeService.excluir(cidadeId);
			return ResponseEntity.noContent().build();

		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();

		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

}
