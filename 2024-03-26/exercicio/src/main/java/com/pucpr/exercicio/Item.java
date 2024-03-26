package com.pucpr.exercicio;

public class Item {
    private String nome;
    private Integer qtdade;
    private double valor;
    private String descritivo;

    public Item(String nome, Integer qtdade, double valor, String descritivo) {
        this.nome = nome;
        this.qtdade = qtdade;
        this.valor = valor;
        this.descritivo = descritivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtdade() {
        return qtdade;
    }

    public void setQtdade(Integer qtdade) {
        this.qtdade = qtdade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescritivo() {
        return descritivo;
    }

    public void setDescritivo(String descritivo) {
        this.descritivo = descritivo;
    }
}
