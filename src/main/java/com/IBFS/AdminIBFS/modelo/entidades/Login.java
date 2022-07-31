package com.IBFS.AdminIBFS.modelo.entidades;

public class Login {
	private String username;
	private String password;
	private String token;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + ", token=" + token + "]";
	}
}
