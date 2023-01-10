package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.api.controller.util.GenericController;
import com.algaworks.cadufood.api.mapper.CozinhaMapper;
import com.algaworks.cadufood.api.mapper.util.GenericMapper;
import com.algaworks.cadufood.api.model.input.CozinhaInput;
import com.algaworks.cadufood.api.model.output.CozinhaOutput;
import com.algaworks.cadufood.domain.model.Cozinha;
import com.algaworks.cadufood.domain.service.CozinhaService;
import com.algaworks.cadufood.domain.service.util.GenericService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cozinhas")
public class CozinhaController extends GenericController<Cozinha, CozinhaInput, CozinhaOutput> {

	@Autowired
	private CozinhaService cozinhaService;

	@Getter
	@Autowired
	private CozinhaMapper mapper;

	public CozinhaController(GenericService<Cozinha> service, GenericMapper<Cozinha, CozinhaInput, CozinhaOutput> mapper) {
		super(service, mapper);
	}

	@PutMapping("/{cozinhaId}")
	public ResponseEntity<CozinhaOutput> atualizar(@PathVariable Long cozinhaId,
												   @RequestBody CozinhaInput cozinhaInput) {
		Cozinha cozinhaAtual = cozinhaService.atualizar(cozinhaId, cozinhaInput);
		return ResponseEntity.ok(mapper.toOutput(cozinhaAtual));
	}

}
