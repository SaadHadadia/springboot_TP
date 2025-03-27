package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonBackReference("user-login")
    @OneToMany(mappedBy = "user")
    private List<Login> logins;

    @JsonBackReference("user-affectation")
    @OneToMany(mappedBy = "user")
    private List<Affectation> affectations;

    public User() {
        super();
    }

    public User(String nom, String grade) {
        super();
        this.nom = nom;
        this.grade = grade;
    }
}
