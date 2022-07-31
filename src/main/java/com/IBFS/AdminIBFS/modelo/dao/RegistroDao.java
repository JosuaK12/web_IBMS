package com.IBFS.AdminIBFS.modelo.dao;

import java.util.HashMap;
import java.util.List;

import com.IBFS.AdminIBFS.modelo.entidades.Registro;

public interface RegistroDao {
	public HashMap<String, Object> insertarRegistro(Registro nuevoRegistro);
	public void actualizarRegistro(Registro actualizarRegistro);
	public void borrarRegistro(Registro borrarRegistro);
	public List<Registro> listarRegistro();
}
