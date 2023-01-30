package com.algaworks.cadufood.core.generic.crud.controller;

import com.algaworks.cadufood.core.generic.crud.controller.apiannotations.DeleteAnnotations;
import com.algaworks.cadufood.core.generic.crud.controller.apiannotations.GetAnnotations;
import com.algaworks.cadufood.core.generic.crud.service.ServicoGenerico;
import com.algaworks.cadufood.core.generic.mapper.MapeadorGenerico;
import com.algaworks.cadufood.core.generic.model.DTO;
import com.algaworks.cadufood.core.generic.model.EntidadeGenerica;
import com.algaworks.cadufood.core.generic.model.ObjetoGenerico;

import java.util.List;

/**
 * Classe que representa um controlador REST personalizado.
 *
 * Fornece uma implementação do Controlador Genérico
 * sem mapeamento de método POST e PUT.
 *
 * @author Carlos Eduardo Marques Pereira
 */
public abstract class ControladorExcetoPostPut<
            DomainModel extends EntidadeGenerica,
            InputModel extends ObjetoGenerico,
            OutputModel extends ObjetoGenerico>
        extends ControladorGenerico<DomainModel, InputModel, OutputModel>
        implements GetAnnotations<OutputModel>, DeleteAnnotations {

    public ControladorExcetoPostPut(ServicoGenerico<DomainModel> servico, MapeadorGenerico<DomainModel, InputModel, OutputModel> mapper) {
        super(servico, mapper);
    }

    @Override
    public List<OutputModel> listar() {
        return super.listar();
    }

    @Override
    public OutputModel buscar(String codigo) {
        return super.buscar(codigo);
    }

    @Override
    public void excluir(String codigo) {
        super.excluir(codigo);
    }
}
