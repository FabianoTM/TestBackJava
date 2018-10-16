package br.com.resource.santander.gestaodegastosapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.resource.santander.gestaodegastosapi.exception.GestaoGastosException;
import br.com.resource.santander.gestaodegastosapi.model.Categoria;
import br.com.resource.santander.gestaodegastosapi.repository.impl.CategoriaRepositoryImpl;

@Service
public class CategoriaServiceImpl {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CategoriaRepositoryImpl categoriaRepository;

    public List<String> listarCategorias(String filtro) throws GestaoGastosException {

        logger.info("Preparando consulta de categorias");
        List<Categoria> categorias = categoriaRepository.listarCategorias();
        if (StringUtils.isNotBlank(filtro)) {
            logger.info("Filtrando o resultado - Filtro: \"" +filtro + "\"");
            categorias = categorias.stream()
                    .filter(categoria -> StringUtils.containsIgnoreCase(categoria.getDescricao(), filtro))
                    .collect(Collectors.toList());

            logger.info("Resultado com filtro: " + categorias.size() + " registros");
        }
        return categorias.stream().map(e -> e.getDescricao()).collect(Collectors.toList());

    }
}
