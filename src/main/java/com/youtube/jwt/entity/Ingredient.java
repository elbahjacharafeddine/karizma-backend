package com.youtube.jwt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nom;

    @ManyToMany(mappedBy = "ingredients")
    private List<Recette> recettes;

    public Ingredient(String nom) {
        this.nom = nom;
    }


    public Ingredient() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
