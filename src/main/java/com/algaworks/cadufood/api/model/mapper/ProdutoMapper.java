package com.algaworks.cadufood.api.model.mapper;

import com.algaworks.cadufood.api.model.input.ProdutoInput;
import com.algaworks.cadufood.api.model.output.ProdutoOutput;
import com.algaworks.cadufood.core.generic.mapper.MapeadorGenerico;
import com.algaworks.cadufood.domain.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper extends MapeadorGenerico<Produto, ProdutoInput, ProdutoOutput> {

    public ProdutoMapper() {
        super(Produto.class, ProdutoInput.class, ProdutoOutput.class);
    }

}
