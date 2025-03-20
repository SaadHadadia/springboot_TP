package com.example.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("Administrative")
@Getter
@Setter
public class FonctionAdministrative extends Fonction {
    private String description;

    public FonctionAdministrative() {
        super();
    }
}
