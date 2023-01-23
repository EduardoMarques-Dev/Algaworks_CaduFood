package com.algaworks.cadufood.core.generic.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public interface FatherEntity extends GenericEntity {

    Map<String, Collection> getSubRecursos();

    default Collection<?> listarSubRecurso(String chave){
        var subRecursos = getSubRecursos();
        return subRecursos.containsKey(chave) ?
                subRecursos.get(chave).stream().toList() : new ArrayList<>();
    }

    default Collection<?> buscarSubRecurso(String chave, GenericEntity subRecurso) {
        var subRecursos = getSubRecursos();
        if (subRecursos.containsKey(chave)){
            return subRecursos.get(chave).stream().filter(
                    x -> x.equals(subRecurso)
            ).toList();
        }
        return new ArrayList<>();
    }

    default void associarSubRecurso(String chave, GenericEntity subRecurso) {
        var subRecursos = getSubRecursos();
        if (subRecursos.containsKey(chave)){
            subRecursos.get(chave).add(subRecurso);
        }
    }

    default void desassociarSubRecurso(String chave, GenericEntity subRecurso) {
        var subRecursos = getSubRecursos();
        if (subRecursos.containsKey(chave)){
            subRecursos.get(chave).remove(subRecurso);
        }
    }

}
