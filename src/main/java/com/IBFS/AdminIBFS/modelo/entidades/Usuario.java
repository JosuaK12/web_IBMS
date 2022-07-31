package com.IBFS.AdminIBFS.modelo.entidades;

public class Usuario {
	
	private int id;
	private String first_name;
	private String last_name;
	private String username;
	private String email;
	private String password;
	private String image;
	private int roles_id;
	private String rol;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getRoles_id() {
		return roles_id;
	}
	public void setRoles_id(int roles_id) {
		this.roles_id = roles_id;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", username="
				+ username + ", email=" + email + ", password=" + password + ", image=" + image + ", roles_id="
				+ roles_id + ", rol=" + rol + "]";
	}
}
