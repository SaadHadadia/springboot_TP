package com.example.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@DiscriminatorValue("Technique")
public class FonctionTechnique extends Fonction {
    private String technos;
    public FonctionTechnique(){
        super();
    }
}
