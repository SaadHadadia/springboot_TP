package com.example.DTO;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class UserDTO {
    private String nom;
    private List<String> logins;

    public UserDTO() {
    }

    public UserDTO(String nom, List<String> logins) {
        this.nom = nom;
        this.logins = logins;
    }
}
