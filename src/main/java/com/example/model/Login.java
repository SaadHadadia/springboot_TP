package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Login {
	@Id
	private String login;
	private String mdp;

	@JsonBackReference
	@ManyToOne
	User user;

	public Login() {
		super();
	}

	public Login(String login, String mdp) {
		super();
		this.login = login;
		this.mdp = mdp;
	}
}
