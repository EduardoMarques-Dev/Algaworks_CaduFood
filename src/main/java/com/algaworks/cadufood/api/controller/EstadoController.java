package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.api.controller.util.GenericController;
import com.algaworks.cadufood.api.mapper.EstadoMapper;
import com.algaworks.cadufood.api.mapper.util.GenericMapper;
import com.algaworks.cadufood.api.model.input.EstadoInput;
import com.algaworks.cadufood.api.model.output.EstadoOutput;
import com.algaworks.cadufood.domain.model.Estado;
import com.algaworks.cadufood.domain.service.EstadoService;
import com.algaworks.cadufood.domain.service.util.GenericService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController extends GenericController<Estado,EstadoInput,EstadoOutput> {

	@Autowired
	private EstadoService estadoService;

	@Getter
	@Autowired
	private EstadoMapper mapper;

	public EstadoController(EstadoService service, EstadoMapper mapper) {
		super(service, mapper);
	}

	@PutMapping("/{estadoId}")
	public ResponseEntity<EstadoOutput> atualizar(@PathVariable Long estadoId,
												  @RequestBody EstadoInput estadoInput) {

		Estado estado = estadoService.atualizar(estadoId, estadoInput);
		return ResponseEntity.ok(mapper.toOutput(estado));
	}

}
