package com.algaworks.cadufood.core.generic.model;

import java.util.Collection;

public interface FatherEntity<DomainModel> extends GenericEntity<DomainModel> {

    Collection<?> listarSubRecurso(Object subRecurso);

    Collection<?> buscarSubRecurso(Object ChildModel);

    boolean associarSubRecurso(Object subRecurso);

    boolean desassociarSubRecurso(Object subRecurso);

}
