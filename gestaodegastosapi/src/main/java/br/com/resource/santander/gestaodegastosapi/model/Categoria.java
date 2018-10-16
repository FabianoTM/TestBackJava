package br.com.resource.santander.gestaodegastosapi.model;

public class Categoria {

    private Integer id;
    private String descricao;

    public Categoria(Integer id, String descricao) {

        super();
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {

        return id;
    }

    public String getDescricao() {

        return descricao;
    }

}
