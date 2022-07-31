package com.IBFS.AdminIBFS.modelo.entidades;

public class Publicacion {
	
	private int id;
	private String pub_titulo;
	private String pub_contenido;
	private String pub_fechaPublic;
	private int user_id;
	private String user;
	private int categoria_id;
	private String categoria;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPub_titulo() {
		return pub_titulo;
	}
	public void setPub_titulo(String pub_titulo) {
		this.pub_titulo = pub_titulo;
	}
	public String getPub_contenido() {
		return pub_contenido;
	}
	public void setPub_contenido(String pub_contenido) {
		this.pub_contenido = pub_contenido;
	}
	public String getPub_fechaPublic() {
		return pub_fechaPublic;
	}
	public void setPub_fechaPublic(String pub_fechaPublic) {
		this.pub_fechaPublic = pub_fechaPublic;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public int getCategoria_id() {
		return categoria_id;
	}
	public void setCategoria_id(int categoria_id) {
		this.categoria_id = categoria_id;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	@Override
	public String toString() {
		return "Publicacion [id=" + id + ", pub_titulo=" + pub_titulo + ", pub_contenido=" + pub_contenido
				+ ", pub_fechaPublic=" + pub_fechaPublic + ", user_id=" + user_id + ", user=" + user + ", categoria_id="
				+ categoria_id + ", categoria=" + categoria + "]";
	}
}
