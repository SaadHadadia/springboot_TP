package com.example.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Technique")
public class FonctionTechnique extends Fonction {
    private String technos;
    public FonctionTechnique(){
        super();
    }
}
