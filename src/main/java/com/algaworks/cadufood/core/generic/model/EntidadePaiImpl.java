package com.algaworks.cadufood.core.generic.model;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe que representa uma entidade REST pai.
 *
 * Corresponde às entidades que possuem subEntidades.
 *
 * @author Carlos Eduardo Marques Pereira
 */
@RequiredArgsConstructor
public class EntidadePaiImpl implements ObjetoGenerico{

    private final EntidadePai fatherEntity;

    private final Map<String, Collection<EntidadeGenerica>> subRecursos = new HashMap<>();



    public void adicionarSubrecurso(String chave, Collection<?> subrecurso){
        subRecursos.put(chave, subrecurso.stream().map(item -> (EntidadeGenerica) item)
                .toList());
    }

    public void setSubRecursos() {
        fatherEntity.setSubRecursos();
    }

    public Map<String, Collection<EntidadeGenerica>> getSubRecursos(){
        if (subRecursos.isEmpty()){
            setSubRecursos();
        }
        return subRecursos;
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
}
