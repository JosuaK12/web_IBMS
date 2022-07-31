package com.IBFS.AdminIBFS.modelo.entidades;

public class Roles {

	private int id;

	private String nombreRol;
	private String descripcionRol;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	public String getDescripcionRol() {
		return descripcionRol;
	}
	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}
	@Override
	public String toString() {
		return "Roles [id=" + id + ", nombreRol=" + nombreRol + ", descripcionRol=" + descripcionRol + "]";
	}
}
