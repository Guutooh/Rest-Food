package com.rest.food.api.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.food.domain.exception.CozinhaNaoEncontradaException;
import com.rest.food.domain.exception.NegocioException;
import com.rest.food.domain.model.Restaurante;
import com.rest.food.domain.repository.RestauranteRepository;
import com.rest.food.domain.service.RestauranteService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {


    @Autowired
    RestauranteRepository restauranteRepository;

    @Autowired
    RestauranteService restauranteService;


    @GetMapping()
    public List<Restaurante> listar() {
        return restauranteRepository.findAll();
    }


    @GetMapping("/{restauranteId}")
    public Restaurante buscar(@PathVariable Long restauranteId) {

        return restauranteService.buscarOuFalhar(restauranteId);

    }

    @PostMapping()
    public Restaurante adicionar(@RequestBody Restaurante restaurante) {

        try {
            return restauranteService.salvar(restaurante);
        } catch (CozinhaNaoEncontradaException e) {
            throw new NegocioException(e.getMessage());
        }

    }

    @PutMapping("/{restauranteId}")
    public Restaurante atualizar(@PathVariable Long restauranteId,
                                 @RequestBody Restaurante restaurante) {

        try {
            Restaurante restauranteAtual = restauranteService.buscarOuFalhar(restauranteId);

            BeanUtils.copyProperties(restaurante, restauranteAtual,
                    "id", "formasPagamento", "endereco", "dataCadastro", "produtos");

            return restauranteService.salvar(restauranteAtual);
        } catch (CozinhaNaoEncontradaException e) {
            throw new NegocioException(e.getMessage());
        }

    }


    @PatchMapping("/{restauranteId}")
    public Restaurante atualizarParcial(@PathVariable Long restauranteId,
                                        @RequestBody Map<String, Object> campos, HttpServletRequest request) {


        Restaurante restauranteAtual = restauranteService.buscarOuFalhar(restauranteId);

        merge(campos, restauranteAtual, request);

        return atualizar(restauranteId, restauranteAtual);
    }

    private void merge(Map<String, Object> dadosOrigem, Restaurante restauranteDestino,
                       HttpServletRequest request) {


        ServletServerHttpRequest serverHttpRequest = new ServletServerHttpRequest(request);

        try {

            ObjectMapper objectMapper = new ObjectMapper();

            objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, true);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

            Restaurante restauranteOrigem = objectMapper.convertValue(dadosOrigem, Restaurante.class);

            dadosOrigem.forEach((nomePropriedade, valorPropriedade) -> {

                Field field = ReflectionUtils.findField(Restaurante.class, nomePropriedade);

                field.setAccessible(true);

                Object novoValor = ReflectionUtils.getField(field, restauranteOrigem);

                ReflectionUtils.setField(field, restauranteDestino, novoValor);
            });

        } catch (IllegalArgumentException e) {
            Throwable rootCause = ExceptionUtils.getRootCause(e);
            throw new HttpMessageNotReadableException(e.getMessage(), rootCause, serverHttpRequest);
        }
    }

}
