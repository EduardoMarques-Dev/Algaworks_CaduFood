package com.algaworks.cadufood.core.generic.model;

import java.util.Collection;
import java.util.Map;

/**
 * Interface que representa uma entidade REST pai.
 *
 * Corresponde às entidades que possuem subEntidades.
 *
 * @author Carlos Eduardo Marques Pereira
 */
public interface EntidadePai extends EntidadeGenerica{

    void setSubRecursos();

    Map<String, Collection<EntidadeGenerica>> getSubRecursos();

    Collection<?> listarSubRecurso(String chave);

    Collection<?> buscarSubRecurso(String chave, EntidadeGenerica subRecurso);

    void associarSubRecurso(String chave, EntidadeGenerica subRecurso);

    void desassociarSubRecurso(String chave, EntidadeGenerica subRecurso);
}
