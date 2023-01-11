package com.algaworks.cadufood.api.model.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IdInput {

    @NotNull
    private Long id;

}
