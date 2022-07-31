package com.IBFS.AdminIBFS.controlador;

import java.util.HashMap;

import com.IBFS.AdminIBFS.modelo.entidades.Login;

public interface LoginControlador {
	public HashMap<String, Object> inciarSesion(Login nuevoLogin);
}
