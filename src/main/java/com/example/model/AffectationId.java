package com.example.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class AffectationId {
    private int userId;
    private String fonctionId;

    public AffectationId() {
        super();
    }
    public AffectationId(int userId, String fonctionId) {
        super();
        this.userId = userId;
        this.fonctionId = fonctionId;
    }
}
