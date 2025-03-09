package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Login {

	public Login(String login, String mdp) {
		super();
		this.login = login;
		this.mdp = mdp;
	}
	@Id
	private String login;
	private String mdp;

	public Login() {
		super();
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
}
