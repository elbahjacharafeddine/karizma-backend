package com.youtube.jwt.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Etape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nom;

    @ManyToMany(mappedBy = "etapes")
    private List<Recette> recettes;

    public Etape(String nom) {
        this.nom = nom;
    }

    public Etape() {

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
