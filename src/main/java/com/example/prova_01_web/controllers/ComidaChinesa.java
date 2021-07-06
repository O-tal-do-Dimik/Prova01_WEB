package com.example.prova_01_web.controllers;

public class ComidaChinesa {

    private Integer id;
    private String nome;
    private Double preco;
    private String descricao;
    private String validade;
    private Double calorias;

    public ComidaChinesa(Integer id, String nome, Double preco, String descricao, String validade, Double calorias) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.validade = validade;
        this.calorias = calorias;
    }

    public Integer getid() {
        return id;
    }

    public void setid(Integer id) {
        this.id = id;
    }

    public String getnome() {
        return nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public Double getpreco() {
        return preco;
    }

    public void setpreco(Double preco) {
        this.preco = preco;
    }

    public String getdescricao() {
        return descricao;
    }

    public void setdescricao(String descricao) {
        this.descricao = descricao;
    }


    public String getvalidade() {
        return validade;
    }

    public void setvalidade(String validade) {
        this.validade = validade;
    }

    public Double getcalorias() {
        return calorias;
    }

    public void setcalorias(Double calorias) {
        this.calorias = calorias;
    }

}
