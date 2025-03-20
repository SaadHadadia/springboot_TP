package com.example.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class AffectationId {
    private int login;
    private String libelle;

    public AffectationId() {
        super();
    }
    public AffectationId(int login, String libelle) {
        super();
        this.login = login;
        this.libelle = libelle;
    }
}
