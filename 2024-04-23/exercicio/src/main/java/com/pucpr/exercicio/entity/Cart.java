package com.pucpr.exercicio.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String username;
    private Date date;


    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private Set<Item> items = new HashSet<>();

    public Cart() {
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @JsonManagedReference(value = "cart")
    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
