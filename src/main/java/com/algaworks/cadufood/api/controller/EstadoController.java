package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.api.mapper.EstadoMapper;
import com.algaworks.cadufood.api.model.input.EstadoInput;
import com.algaworks.cadufood.api.model.output.EstadoOutput;
import com.algaworks.cadufood.domain.model.Estado;
import com.algaworks.cadufood.domain.service.EstadoService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	private EstadoService estadoService;

	@Getter
	private EstadoMapper mapper;

	@GetMapping
	public List<EstadoOutput> listar() {
		return mapper.toOutputCollection(estadoService.listar());
	}

	@GetMapping("/{estadoId}")
	public ResponseEntity<EstadoOutput> buscar(@PathVariable Long estadoId) {
		Estado estado = estadoService.buscar(estadoId);
		return ResponseEntity.ok(
				mapper.toOutput(estado));
	}

	@PostMapping
	public ResponseEntity<EstadoOutput> salvar(@RequestBody EstadoInput estadoInput) {
		Estado estado = mapper.toDomain(estadoInput);
		estado = estadoService.salvar(estado);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(mapper.toOutput(estado));
	}

	@PutMapping("/{estadoId}")
	public ResponseEntity<EstadoOutput> atualizar(@PathVariable Long estadoId,
												  @RequestBody EstadoInput estadoInput) {

		Estado estado = estadoService.atualizar(estadoId, estadoInput);
		return ResponseEntity.ok(mapper.toOutput(estado));
	}

	@DeleteMapping("/{estadoId}")
	public ResponseEntity<EstadoOutput> excluir(@PathVariable Long estadoId) {
		estadoService.excluir(estadoId);
		return ResponseEntity.noContent().build();
	}

}
