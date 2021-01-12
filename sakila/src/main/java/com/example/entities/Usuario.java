package com.example.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Usuario {
	private String username;
	private String password;

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Usuario() {}
	public Usuario(String username, String password) {
		this.username = username;
		this.password = password;
	}


}
