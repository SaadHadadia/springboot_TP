package com.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@Entity
public class Affectation {

    @EmbeddedId
    private AffectationId id;
    @Temporal(TemporalType.DATE)
    private Date db;
    @Temporal(TemporalType.DATE)
    private Date df;
    @ManyToOne
    @MapsId("login")
    private User user;
    @ManyToOne
    @MapsId("libelle")
    private Fonction fonction;

    public Affectation() {
        super();
    }

    public Affectation(AffectationId id, Date db, Date df) {
        super();
        this.id = id;
        this.db = db;
        this.df = df;
    }
}
