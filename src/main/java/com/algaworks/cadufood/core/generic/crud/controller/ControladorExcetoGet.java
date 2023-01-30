package com.algaworks.cadufood.core.generic.crud.controller;

import com.algaworks.cadufood.core.generic.crud.controller.apiannotations.DeleteAnnotations;
import com.algaworks.cadufood.core.generic.crud.controller.apiannotations.PostPutAnnotations;
import com.algaworks.cadufood.core.generic.crud.service.ServicoGenerico;
import com.algaworks.cadufood.core.generic.mapper.MapeadorGenerico;
import com.algaworks.cadufood.core.generic.model.DTO;
import com.algaworks.cadufood.core.generic.model.EntidadeGenerica;
import com.algaworks.cadufood.core.generic.model.ObjetoGenerico;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

/**
 * Classe que representa um controlador REST personalizado.
 *
 * Fornece uma implementação do Controlador Genérico
 * sem mapeamento de método GET.
 *
 * @author Carlos Eduardo Marques Pereira
 */
public abstract class ControladorExcetoGet<
            DomainModel extends EntidadeGenerica,
            InputModel extends ObjetoGenerico,
            OutputModel extends ObjetoGenerico>
        extends ControladorGenerico<DomainModel, InputModel, OutputModel>
        implements PostPutAnnotations<InputModel,OutputModel>, DeleteAnnotations {


    public ControladorExcetoGet(ServicoGenerico<DomainModel> servico, MapeadorGenerico<DomainModel, InputModel, OutputModel> mapper) {
        super(servico, mapper);
    }

    @Override
    public OutputModel salvar(InputModel inputModel) {
        return super.salvar(inputModel);
    }

    @Override
    public OutputModel atualizar(String codigo, InputModel inputModel) {
        return super.atualizar(codigo, inputModel);
    }

    @Override
    public OutputModel atualizarParcial(String codigo, HashMap<String, Object> fields) {
        return super.atualizarParcial(codigo, fields);
    }

    @Override
    public void excluir(String codigo) {
        super.excluir(codigo);
    }
}
