package com.IBFS.AdminIBFS.modelo.entidades;

public class Categoria {
	
	private int id;
	private String cat_nombre;
	private String cat_descripcion;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCat_nombre() {
		return cat_nombre;
	}
	public void setCat_nombre(String cat_nombre) {
		this.cat_nombre = cat_nombre;
	}
	public String getCat_descripcion() {
		return cat_descripcion;
	}
	public void setCat_descripcion(String cat_descripcion) {
		this.cat_descripcion = cat_descripcion;
	}
	@Override
	public String toString() {
		return "Categoria [id=" + id + ", cat_nombre=" + cat_nombre + ", cat_descripcion=" + cat_descripcion + "]";
	}
	
}
