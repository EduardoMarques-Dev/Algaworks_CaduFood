package com.algaworks.cadufood.core.generic.crud.controller;

import com.algaworks.cadufood.core.generic.crud.controller.apiannotations.AllApiAnnotations;
import com.algaworks.cadufood.core.generic.model.DTO;
import com.algaworks.cadufood.core.generic.model.EntidadeGenerica;

import java.util.HashMap;
import java.util.List;

/**
 * Classe que representa um controlador REST básico.
 *
 * Fornece uma implementação do Controlador Genérico
 * com todos os métodos mapeados.
 *
 * @author Carlos Eduardo Marques Pereira
 */
public abstract class ControladorBasico<
        DomainModel extends EntidadeGenerica,
        InputModel extends DTO,
        OutputModel extends DTO>
        extends ControladorGenerico<DomainModel, InputModel, OutputModel>
        implements AllApiAnnotations<InputModel,OutputModel> {

    @Override
    public List<OutputModel> listar() {
        return super.listar();
    }

    @Override
    public OutputModel buscar(String code) {
        return super.buscar(code);
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
