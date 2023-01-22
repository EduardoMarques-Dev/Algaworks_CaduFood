package com.algaworks.cadufood.core.generic.model;

import java.util.Collection;

public interface FatherEntity<DomainModel> extends GenericEntity<DomainModel> {

    Collection<?> listarSubRecurso(String subRecurso);

}
