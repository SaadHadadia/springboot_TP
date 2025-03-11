package com.example.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Fonction {
    @Id
    private String libelle;

    @ManyToMany
    @JoinTable(
            name = "Fonction_User",
            joinColumns =@JoinColumn(name = "libelle"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<User> users;

    public Fonction() {
        super();
    }

    public Fonction(String libelle) {
        super();
        this.libelle = libelle;
    }
}
