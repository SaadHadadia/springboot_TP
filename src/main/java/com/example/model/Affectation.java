package com.example.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Affectation {

    @EmbeddedId
    private AffectationId id;
    private String db;
    private String df;
    @ManyToOne
    private User user;
    @ManyToOne
    private Fonction fonction;

    public Affectation() {
        super();
    }

    public Affectation(AffectationId id, String db, String df) {
        super();
        this.id = id;
        this.db = db;
        this.df = df;
    }
}
