package com.algaworks.cadufood.core.generic.crud.controller;

import com.algaworks.cadufood.core.generic.crud.service.ServicoGenerico;
import com.algaworks.cadufood.core.generic.mapper.MapeadorGenerico;
import com.algaworks.cadufood.core.generic.model.EntidadeGenerica;
import com.algaworks.cadufood.core.generic.model.ObjetoGenerico;
import com.algaworks.cadufood.domain.exception.NegocioException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.List;

/**
 * Classe que representa um controlador REST genérico.
 *
 * @author Carlos Eduardo Marques Pereira
 */
@RequiredArgsConstructor
public abstract class ControladorGenerico<
        DomainModel extends EntidadeGenerica,
        InputModel extends ObjetoGenerico,
        OutputModel extends ObjetoGenerico> {

    protected final ServicoGenerico<DomainModel> servico;

    protected final MapeadorGenerico<DomainModel, InputModel, OutputModel> mapper;

    public List<OutputModel> listar() {
        return mapper.toOutputCollection(servico.listar());
    }

    public OutputModel buscar(String codigo) {
        DomainModel domainModel = servico.buscar(codigo);
        return mapper.toOutput(domainModel);
    }

    @ResponseStatus(HttpStatus.CREATED)
    public OutputModel salvar(InputModel inputModel) {
        DomainModel domainModel = mapper.toDomain(inputModel);
        domainModel = servico.salvar(domainModel);
        return mapper.toOutput(domainModel);
    }

    @Transactional
    public OutputModel atualizar(String codigo,
                                 InputModel inputModel) {
        try {
            DomainModel domainModel = servico.buscar(codigo);
            mapper.updateEntity(inputModel, domainModel);
            return mapper.toOutput(servico.recarregar(domainModel));
        } catch (DataIntegrityViolationException ex) {
            throw new NegocioException(ex);
        }
    }

    @Transactional
    public OutputModel atualizarParcial(String codigo,
                                        HashMap<String,Object> fields) {
        try {
            DomainModel domainModel = servico.buscar(codigo);
            mapper.patchEntity(fields, domainModel);
            return mapper.toOutput(servico.recarregar(domainModel));
        } catch (DataIntegrityViolationException ex) {
            throw new NegocioException(ex);
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(String codigo) {
        servico.excluir(codigo);
    }
}
