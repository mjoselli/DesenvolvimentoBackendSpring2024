package com.pucpr.exercicio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String nome;
    private Integer qtdade;
    private double valor;
    private String descritivo;
    

    public Item() {
        
    }
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
