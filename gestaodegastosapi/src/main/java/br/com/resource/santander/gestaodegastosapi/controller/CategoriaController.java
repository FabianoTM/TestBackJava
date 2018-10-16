package br.com.resource.santander.gestaodegastosapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.resource.santander.gestaodegastosapi.model.ApiError;
import br.com.resource.santander.gestaodegastosapi.service.impl.CategoriaServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping (value = "/categoria")
public class CategoriaController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CategoriaServiceImpl categoriaService;

    @ApiOperation (value = "Listar categorias.", notes = "Retorna a lista de categorias disponíveis. Esse método possui um parametro opcional para efetuar busca das categorias.", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, response = String.class, responseContainer = "List")
    @RequestMapping (value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getCategorias(
            @ApiParam (value = "Filtrar descrição da categoria (opcional)", required = false) @RequestParam (value = "filtro", required = false) String filtro) {

        try {
            List<String> categorias = categoriaService.listarCategorias(filtro);
            return new ResponseEntity<>(categorias, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Ocorreu um erro ao listar as categorias:" + e.getMessage());
            ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "Ocorreu um erro ao listar as categorias");
            return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getHttpStatus());
        }

    }
}
