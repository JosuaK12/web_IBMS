package com.IBFS.AdminIBFS.modelo.dao;

import java.util.HashMap;

import com.IBFS.AdminIBFS.modelo.entidades.Login;

public interface LoginDao {
	
	public HashMap<String, Object> inciarSesion(Login nuevoLogin);
}
