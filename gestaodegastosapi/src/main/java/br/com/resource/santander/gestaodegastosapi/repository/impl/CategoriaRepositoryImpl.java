package br.com.resource.santander.gestaodegastosapi.repository.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.resource.santander.gestaodegastosapi.exception.GestaoGastosException;
import br.com.resource.santander.gestaodegastosapi.model.Categoria;

@Repository
public class CategoriaRepositoryImpl {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private static final String SELECT_CATEGORIAS = "  SELECT * FROM TBL_CATEGORIA";

    public List<Categoria> listarCategorias() throws GestaoGastosException {

        List<Categoria> categorias;
        try {
            logger.info("Efetuando consulta das categorias no BD:");
            categorias = this.jdbcTemplate.query(SELECT_CATEGORIAS, (rs, rowNum) -> {
                Categoria evento = new Categoria(rs.getInt("ID"), rs.getString("DESCRICAO"));
                return evento;
            });
            logger.info("Resultado da consulta: " + categorias.size() + " registros");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new GestaoGastosException("Erro ao consultar a lista de categorias.");
        }
        return categorias;
    }
}
