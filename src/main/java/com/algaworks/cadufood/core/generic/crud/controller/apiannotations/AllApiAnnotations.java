package com.algaworks.cadufood.core.generic.crud.controller.apiannotations;

public interface AllApiAnnotations<InputModel, OutputModel>
        extends GetAnnotations<OutputModel>,
        PostPutAnnotations<InputModel,OutputModel>,
        DeleteAnnotations {
}
