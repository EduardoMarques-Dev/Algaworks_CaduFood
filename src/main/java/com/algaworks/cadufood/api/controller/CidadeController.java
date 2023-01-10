package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.api.controller.util.GenericController;
import com.algaworks.cadufood.api.mapper.CidadeMapper;
import com.algaworks.cadufood.api.model.input.CidadeInput;
import com.algaworks.cadufood.api.model.output.CidadeOutput;
import com.algaworks.cadufood.domain.model.Cidade;
import com.algaworks.cadufood.domain.service.CidadeService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController extends GenericController<Cidade,CidadeInput,CidadeOutput> {

	@Autowired
	private CidadeService cidadeService;

	@Getter
	@Autowired
	private CidadeMapper mapper;

	public CidadeController(CidadeService service, CidadeMapper mapper) {
		super(service, mapper);
	}

	@PutMapping("/{cidadeId}")
	public CidadeOutput atualizar(@PathVariable Long cidadeId,
								  @RequestBody CidadeInput cidadeInput) {
		Cidade cidadeAtual = cidadeService.atualizar(cidadeId, cidadeInput);
		return mapper.toOutput(cidadeAtual);
	}

}
