package com.IBFS.AdminIBFS.modelo.entidades;

public class Registro {
	
	private int id;
	private String reg_fechaRegistro;
	private boolean reg_asistencia;
	private int user_id;
	private String user;
	private String eventos;
	private int eventos_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReg_fechaRegistro() {
		return reg_fechaRegistro;
	}
	public void setReg_fechaRegistro(String reg_fechaRegistro) {
		this.reg_fechaRegistro = reg_fechaRegistro;
	}
	public boolean getReg_asistencia() {
		return reg_asistencia;
	}
	public void setReg_asistencia(boolean reg_asistencia) {
		this.reg_asistencia = reg_asistencia;
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
	public String getEventos() {
		return eventos;
	}
	public void setEventos(String eventos) {
		this.eventos = eventos;
	}
	public int getEventos_id() {
		return eventos_id;
	}
	public void setEventos_id(int eventos_id) {
		this.eventos_id = eventos_id;
	}
	@Override
	public String toString() {
		return "Registro [id=" + id + ", reg_fechaRegistro=" + reg_fechaRegistro + ", reg_asistencia=" + reg_asistencia
				+ ", user_id=" + user_id + ", user=" + user + ", eventos=" + eventos + ", eventos_id=" + eventos_id
				+ "]";
	}
	
}
