package com.algaworks.cadufood.domain.service;

import com.algaworks.cadufood.api.controller.CidadeController;
import com.algaworks.cadufood.api.model.input.CidadeInput;
import com.algaworks.cadufood.domain.exception.CidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.cadufood.domain.exception.NegocioException;
import com.algaworks.cadufood.domain.model.Cidade;
import com.algaworks.cadufood.domain.repository.CidadeRepository;
import com.algaworks.cadufood.domain.repository.util.norepositorybean.CustomJpaRepository;
import com.algaworks.cadufood.domain.service.util.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CidadeService extends GenericService<Cidade> {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired @Lazy
	private CidadeController cidadeController;

	public CidadeService(CidadeRepository repository) {
		super(repository);
	}

	@Override
	public Cidade buscar(Long idDomainModel) {
		try{
			return super.buscar(idDomainModel);
		}catch (EntidadeNaoEncontradaException ex){
			throw new CidadeNaoEncontradaException(Cidade.class,idDomainModel);
		}
	}

	@Transactional
	public Cidade atualizar(Long cidadeId, CidadeInput cidadeInput) {
		Cidade cidadeAtual = buscarDomainModelOuFalhar(cidadeId);

		cidadeController.getMapper().updateEntity(cidadeInput,cidadeAtual);

		try{
			return salvarERecarregar(cidadeAtual);
		}catch (DataIntegrityViolationException ex){
			throw new NegocioException(ex.getMessage());
		}
	}

}
