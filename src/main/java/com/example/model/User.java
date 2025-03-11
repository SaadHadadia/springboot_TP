package com.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom;
    private String grade;

    @OneToMany(mappedBy = "user")
    private List<Login> logins;

    public User() {
        super();
    }

    public User(int id, String nom, String grade) {
        super();
        this.id = id;
        this.nom = nom;
        this.grade = grade;
    }
}
