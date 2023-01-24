package com.algaworks.cadufood.api.controller;

import com.algaworks.cadufood.api.model.input.RestauranteInput;
import com.algaworks.cadufood.api.model.mapper.RestauranteMapper;
import com.algaworks.cadufood.api.model.output.RestauranteOutput;
import com.algaworks.cadufood.core.generic.crud.controller.ExceptGetController;
import com.algaworks.cadufood.domain.model.Restaurante;
import com.algaworks.cadufood.domain.repository.util.filter.RestauranteFiltros;
import com.algaworks.cadufood.domain.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/restaurantes")
public class RestauranteController extends ExceptGetController<Restaurante, RestauranteInput, RestauranteOutput> {

    @Autowired
    private RestauranteService restauranteService;

    @Autowired
    private RestauranteMapper mapper;

    @GetMapping
    public Page<RestauranteOutput> buscarPersonalizado(RestauranteFiltros restauranteFiltros, Pageable pageable) {
        Page<Restaurante> restaurante = restauranteService.buscarPersonalizado(restauranteFiltros, pageable);
        return mapper.toOutputCollection(restaurante);
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

