package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @JsonBackReference
    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @JsonBackReference
    @ManyToOne
    @MapsId("fonctionId")
    @JoinColumn(name = "fonction_libelle")
    private Fonction fonction;

    private Date db;
    private Date df;

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
