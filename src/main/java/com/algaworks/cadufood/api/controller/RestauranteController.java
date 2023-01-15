package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.api.mapper.RestauranteMapper;
import com.algaworks.cadufood.api.model.input.RestauranteInput;
import com.algaworks.cadufood.api.model.output.RestauranteOutput;
import com.algaworks.cadufood.core.generic.crud.GenericController;
import com.algaworks.cadufood.domain.model.Restaurante;
import com.algaworks.cadufood.domain.model.util.parametrosBusca.RestauranteParametros;
import com.algaworks.cadufood.domain.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/restaurantes")
public class RestauranteController extends GenericController<Restaurante, RestauranteInput, RestauranteOutput> {

    @Autowired
    private RestauranteService restauranteService;

    @Autowired
    private RestauranteMapper mapper;

    public RestauranteController(RestauranteService service, RestauranteMapper mapper) {
        super(service, mapper);
    }

    @GetMapping("/busca-personalizada")
    public List<RestauranteOutput> buscarPersonalizado(@RequestParam(required = false) String nome,
                                                       @RequestParam(value = "taxa-frete-inicial", required = false) BigDecimal taxaFreteInicial,
                                                       @RequestParam(value = "taxa-frete-final", required = false) BigDecimal taxaFreteFinal,
                                                       @RequestParam(value = "data-cadastro-inicial", required = false) LocalDateTime dataCadastroInicial,
                                                       @RequestParam(value = "data-cadastro-final", required = false) LocalDateTime dataCadastroFinal,
                                                       @RequestParam(value = "data-atualizacao-inicial", required = false) LocalDateTime dataAtualizacaoInicial,
                                                       @RequestParam(value = "taxa-atualizacao-final", required = false) LocalDateTime dataAtualizacaoFinal,
                                                       @RequestParam(value = "endereco-cep", required = false) String enderecoCep,
                                                       @RequestParam(value = "endereco-logradouro", required = false) String enderecoLogradouro,
                                                       @RequestParam(value = "endereco-numero", required = false) String enderecoNumero,
                                                       @RequestParam(value = "endereco-bairro", required = false) String enderecoBairro,
                                                       @RequestParam(value = "endereco-cidade-id", required = false) Long enderecoCidadeId,
                                                       @RequestParam(value = "cozinha-id", required = false) Long cozinhaId) {
        RestauranteParametros restauranteParametros = RestauranteParametros.builder()
                .nome(nome)
                .taxaFreteInicial(taxaFreteInicial)
                .taxaFreteFinal(taxaFreteFinal)
                .dataCadastroInicial(dataCadastroInicial)
                .dataCadastroFinal(dataCadastroFinal)
                .dataAtualizacaoInicial(dataAtualizacaoInicial)
                .dataAtualizacaoFinal(dataAtualizacaoFinal)
                .enderecoCep(enderecoCep)
                .enderecoLogradouro(enderecoLogradouro)
                .enderecoNumero(enderecoNumero)
                .enderecoBairro(enderecoBairro)
                .enderecoCidadeId(enderecoCidadeId)
                .cozinhaId(cozinhaId)
                .build();
        List<Restaurante> restaurante = restauranteService.buscarPersonalizado(restauranteParametros);
        return mapper.toOutputCollection(restaurante);
    }

}

