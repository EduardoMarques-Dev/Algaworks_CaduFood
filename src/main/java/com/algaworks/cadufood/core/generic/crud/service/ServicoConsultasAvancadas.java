package com.algaworks.cadufood.core.generic.crud.service;

import com.algaworks.cadufood.core.generic.crud.repository.RepositorioGenerico;
import com.algaworks.cadufood.core.generic.filter.EspecificacaoGenerica;
import com.algaworks.cadufood.core.generic.filter.FiltroGenerico;
import com.algaworks.cadufood.core.generic.model.EntidadeGenerica;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Classe que representa um serviço REST com filtros dinâmicos.
 *
 * @author Carlos Eduardo Marques Pereira
 */
public abstract class ServicoConsultasAvancadas<
        DomainModel extends EntidadeGenerica,
        GenericFilter extends FiltroGenerico<DomainModel>>
        extends ServicoGenerico<DomainModel> {

    protected EspecificacaoGenerica<DomainModel> especificacaoGenerica;

    public ServicoConsultasAvancadas(RepositorioGenerico<DomainModel, Long> repositorio, EspecificacaoGenerica<DomainModel> especificacaoGenerica) {
        super(repositorio);
        this.especificacaoGenerica = especificacaoGenerica;
    }

    public Page<DomainModel> buscarPersonalizado(GenericFilter genericFilter, Pageable pageable) {
        return repositorio.findAll(especificacaoGenerica.usandoFiltro(genericFilter), pageable);
    }

}
