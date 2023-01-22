package com.algaworks.cadufood.core.generic.model;

import java.util.Collection;

public interface FatherEntity extends GenericEntity {

    Collection<?> listarSubRecurso(Object subRecurso);

    Collection<?> buscarSubRecurso(Object ChildModel);

    void associarSubRecurso(Object subRecurso);

    void desassociarSubRecurso(Object subRecurso);

}
