package com.example.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
public class Fonction {
    @Id
    private String libelle;

    @JsonManagedReference
    @OneToMany(mappedBy = "fonction")
    private List<Affectation> affectations;

    public Fonction() {
        super();
    }

    public Fonction(String libelle) {
        super();
        this.libelle = libelle;
    }
}
