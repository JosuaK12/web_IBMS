package com.IBFS.AdminIBFS.modelo.entidades;

public class Eventos {
	private int id;
	private String eve_nombre;
	private String eve_info;
	private String eve_fecha;
	private String eve_horaInicio;
	private String eve_horaFinal;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEve_nombre() {
		return eve_nombre;
	}
	public void setEve_nombre(String eve_nombre) {
		this.eve_nombre = eve_nombre;
	}
	public String getEve_info() {
		return eve_info;
	}
	public void setEve_info(String eve_info) {
		this.eve_info = eve_info;
	}
	public String getEve_fecha() {
		return eve_fecha;
	}
	public void setEve_fecha(String eve_fecha) {
		this.eve_fecha = eve_fecha;
	}
	public String getEve_horaInicio() {
		return eve_horaInicio;
	}
	public void setEve_horaInicio(String eve_horaInicio) {
		this.eve_horaInicio = eve_horaInicio;
	}
	public String getEve_horaFinal() {
		return eve_horaFinal;
	}
	public void setEve_horaFinal(String eve_horaFinal) {
		this.eve_horaFinal = eve_horaFinal;
	}
	@Override
	public String toString() {
		return "Eventos [id=" + id + ", eve_nombre=" + eve_nombre + ", eve_info=" + eve_info + ", eve_fecha="
				+ eve_fecha + ", eve_horaInicio=" + eve_horaInicio + ", eve_horaFinal=" + eve_horaFinal + "]";
	}
}
