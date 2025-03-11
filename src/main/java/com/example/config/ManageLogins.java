package com.example.config;
import java.util.HashMap;

//singleton
public enum ManageLogins {
	instance;
	
	private HashMap<String, String> liste = new HashMap<String, String>();
	
	public HashMap<String, String> addLogin(String lg, String mp){
		liste.put(lg, mp);
		return liste;
	}
	
	public HashMap<String, String> getListe() {
		return liste;
	}
}
