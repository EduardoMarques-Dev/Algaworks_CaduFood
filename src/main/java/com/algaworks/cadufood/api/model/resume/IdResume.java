package com.algaworks.cadufood.api.model.resume;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IdResume {

    @NotNull
    private Long id;

}
