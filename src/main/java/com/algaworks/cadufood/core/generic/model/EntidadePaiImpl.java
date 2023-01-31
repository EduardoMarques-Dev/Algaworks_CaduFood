package com.algaworks.cadufood.core.generic.model;

import lombok.RequiredArgsConstructor;

import java.util.*;

/**
 * Classe que representa uma entidade REST pai.
 *
 * Corresponde às entidades que possuem subEntidades.
 *
 * @author Carlos Eduardo Marques Pereira
 */
@RequiredArgsConstructor
public class EntidadePaiImpl{

    final EntidadePai fatherEntity;

    protected Map<String, Collection<EntidadeGenerica>> getSubRecursos(){
        return fatherEntity.getSubRecursos();
    }

    public Collection<?> listarSubRecurso(String chave){
        var subRecursos = getSubRecursos();
        return subRecursos.containsKey(chave) ?
                subRecursos.get(chave).stream().toList() : new ArrayList<>();
    }

    public Collection<?> buscarSubRecurso(String chave, EntidadeGenerica subRecurso) {
        var subRecursos = getSubRecursos();
        if (subRecursos.containsKey(chave)){
            return subRecursos.get(chave).stream().filter(
                    x -> x.equals(subRecurso)
            ).toList();
        }
        return new ArrayList<>();
    }

    public void associarSubRecurso(String chave, EntidadeGenerica subRecurso) {
        var subRecursos = getSubRecursos();
        if (subRecursos.containsKey(chave)){
            subRecursos.get(chave).add(subRecurso);
        }
    }

    public void desassociarSubRecurso(String chave, EntidadeGenerica subRecurso) {
        var subRecursos = getSubRecursos();
        if (subRecursos.containsKey(chave)){
            subRecursos.get(chave).remove(subRecurso);
        }
    }

    public void adicionar(Map<String, Collection<EntidadeGenerica>> lista, String chave, Collection<?> subrecurso){
        lista.put(chave, subrecurso.stream().map(item -> (EntidadeGenerica) item)
                .toList());
    }
}
