package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.api.model.input.RestauranteInput;
import com.algaworks.cadufood.api.model.mapper.RestauranteMapper;
import com.algaworks.cadufood.api.model.output.RestauranteOutput;
import com.algaworks.cadufood.core.generic.crud.controller.ControladorConsultasAvancadas;
import com.algaworks.cadufood.core.generic.crud.controller.ControladorExcetoGet;
import com.algaworks.cadufood.core.generic.crud.service.ServicoConsultasAvancadas;
import com.algaworks.cadufood.core.generic.mapper.MapeadorGenerico;
import com.algaworks.cadufood.domain.model.Restaurante;
import com.algaworks.cadufood.domain.repository.util.filter.RestauranteFiltros;
import com.algaworks.cadufood.domain.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/restaurantes")
public class RestauranteController extends ControladorConsultasAvancadas<Restaurante, RestauranteInput, RestauranteOutput, RestauranteFiltros> {

    private final RestauranteService restauranteService;

    public RestauranteController(RestauranteService servico, RestauranteMapper mapper) {
        super(servico, mapper);
        this.restauranteService = servico;
    }

    @Override
    @GetMapping("/{codigo}")
    public RestauranteOutput buscar(@PathVariable String codigo) {
        return super.buscar(codigo);
    }

    @PutMapping("/{restauranteCodigo}/ativo")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void ativar(@PathVariable String restauranteCodigo){
        restauranteService.ativar(restauranteCodigo);
    }

    @DeleteMapping("/{restauranteCodigo}/ativo")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void inativar(@PathVariable String restauranteCodigo){
        restauranteService.inativar(restauranteCodigo);
    }

}

